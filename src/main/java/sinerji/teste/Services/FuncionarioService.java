package sinerji.teste.Services;

import sinerji.teste.DTOs.CargoDTO;
import sinerji.teste.DTOs.FuncionarioDTO;
import sinerji.teste.DTOs.VendaDTO;
import sinerji.teste.Models.FuncionarioRequest;
import sinerji.teste.Models.SalarioInfo;
import sinerji.teste.Repositories.FuncionarioRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<FuncionarioDTO> getFuncionariosByNomes(List<String> nomes) {
        return funcionarioRepository.findFuncionariosInfoByNomes(nomes).stream()
                .map(FuncionarioDTO::fromEntity)
                .collect(Collectors.toList());
    }

    public java.sql.Date stringParaData(String monthYear) throws ParseException {
        String dateString = monthYear + "-01";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date utilDate = format.parse(dateString);
        return new java.sql.Date(utilDate.getTime());
    }

    public ResponseEntity<?> processFuncionarioRequest(FuncionarioRequest request) {
        List<String> nomes = request.getNomes();
        String dataString = request.getData();
        String metodo = request.getMetodo();

        Date data;
        try {
            data = stringParaData(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body("Data inválida: " + dataString);
        }

        Map<String, SalarioInfo> dados = tratamentoDeDados(nomes, data);

        switch (metodo) {
            case "Valor total pago no mês":
                BigDecimal totalPago = valorTotalPagoMes(dados);
                return ResponseEntity.ok(totalPago);
            case "Valor somente em salário no mês":
                BigDecimal totalPagoSomenteSalario = valorTotalPagoMesSomenteSalario(dados);
                return ResponseEntity.ok(totalPagoSomenteSalario);
            case "Valor somente em benefício no mês":
                BigDecimal totalPagoSomenteBeneficio = valorTotalPagoMesSomenteBeneficio(dados);
                return ResponseEntity.ok(totalPagoSomenteBeneficio);
            case "Funcionário com maior salário no mês":
                String maiorSalario = funcionarioMaiorSalario(dados);
                return ResponseEntity.ok(maiorSalario);
            case "Funcionário com maior benefício no mês":
                String maiorBeneficio = funcionarioMaiorBeneficio(dados);
                return ResponseEntity.ok(maiorBeneficio);
            case "Funcionário com mais vendas no mês":
                String maisVendas = funcionarioComMaisVendas(dados);
                return ResponseEntity.ok(maisVendas);
            default:
                return ResponseEntity.badRequest().body("Método desconhecido: " + metodo);
        } 
    }

    public Map<String, SalarioInfo> tratamentoDeDados(List<String> nomes, Date data) {
        List<FuncionarioDTO> funcionarios = getFuncionariosByNomes(nomes);
        Map<String, SalarioInfo> salarioInfoMap = new HashMap<>();

        for (FuncionarioDTO funcionario : funcionarios) {
            Date contratacao = funcionario.getDataContratacao();
            long anos = ChronoUnit.YEARS.between(contratacao.toLocalDate(), data.toLocalDate());

            CargoDTO cargo = funcionario.getCargo();
            BigDecimal salario = cargo.getSalario();
            BigDecimal salarioBonus = cargo.getSalarioBonus().multiply(BigDecimal.valueOf(anos));
            BigDecimal beneficio = cargo.getBeneficio();
            List<VendaDTO> vendas = funcionario.getVendas();
            BigDecimal totalVendaMes = vendas.stream()
                    .filter(venda -> venda.getDataVenda().toLocalDate().equals(data.toLocalDate()))
                    .map(VendaDTO::getValorTotal)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);
            BigDecimal salarioTotalSemBeneficio = salario.add(salarioBonus);
            BigDecimal salarioBeneficio = calculadoraBeneficio(totalVendaMes, beneficio, cargo.getNome(), salarioTotalSemBeneficio );   
            BigDecimal salarioTotal = salarioTotalSemBeneficio.add(salarioBeneficio);        
            SalarioInfo salarioInfo = new SalarioInfo();
            salarioInfo.setNome(funcionario.getNome());
            salarioInfo.setSalario(salario);
            salarioInfo.setSalarioBonus(salarioBonus);
            salarioInfo.setSalarioBeneficio(salarioBeneficio);
            salarioInfo.setTotalEmVendas(totalVendaMes);
            salarioInfo.setSalarioTotal(salarioTotal);

            salarioInfoMap.put(funcionario.getNome(), salarioInfo);
        }
        return salarioInfoMap;
    }

    public BigDecimal calculadoraBeneficio(BigDecimal totalVendaMes, BigDecimal beneficio, String cargo, BigDecimal salarioTotalSemBeneficio) {
        if (totalVendaMes == null) {
            totalVendaMes = BigDecimal.ZERO;
        }
        if (beneficio == null) {
            beneficio = BigDecimal.ZERO;
        }
        BigDecimal salarioBeneficio = BigDecimal.ZERO;
        BigDecimal beneficioPorcentagem = beneficio.divide(new BigDecimal(100));
        switch (cargo) {
            case "Secretário":
                salarioBeneficio = salarioTotalSemBeneficio.multiply(beneficioPorcentagem);
                break;
            case "Vendedor":
                salarioBeneficio = totalVendaMes.multiply(beneficioPorcentagem);
                break;
            default:
                break;
        }
        return salarioBeneficio;
    }

    // Metodos propostos no teste abaixo

    public BigDecimal valorTotalPagoMes(Map<String, SalarioInfo> dados) {
        BigDecimal totalPago = BigDecimal.ZERO;

        for (SalarioInfo salarioInfo : dados.values()) {
            totalPago = totalPago.add(salarioInfo.getSalarioTotal());
        }
        System.out.println("Total pago: " + totalPago);
        return totalPago;
    }

    public BigDecimal valorTotalPagoMesSomenteSalario(Map<String, SalarioInfo> dados) {
        BigDecimal totalPagoSalario = BigDecimal.ZERO;

        for (SalarioInfo salarioInfo : dados.values()) {
            totalPagoSalario = totalPagoSalario.add(salarioInfo.getSalario());
        }
        System.out.println("Total pago: " + totalPagoSalario);
        return totalPagoSalario;
    }

    public BigDecimal valorTotalPagoMesSomenteBeneficio(Map<String, SalarioInfo> dados) {
        BigDecimal totalPagoBeneficio = BigDecimal.ZERO;

        for (SalarioInfo salarioInfo : dados.values()) {
            totalPagoBeneficio = totalPagoBeneficio.add(salarioInfo.getSalarioBeneficio());
        }
        System.out.println("Total pago: " + totalPagoBeneficio);
        return totalPagoBeneficio;
    }

    public String funcionarioMaiorSalario(Map<String, SalarioInfo> dados) {
        BigDecimal maiorSalario = BigDecimal.ZERO;
        String nomeMaiorSalario = "";
    
        for (SalarioInfo salarioInfo : dados.values()) {
            if (salarioInfo.getSalarioTotal().compareTo(maiorSalario) > 0) {
                maiorSalario = salarioInfo.getSalarioTotal();
                nomeMaiorSalario = salarioInfo.getNome();
            }
        }
        System.out.println("Maior salário: " + nomeMaiorSalario);
        return nomeMaiorSalario;
    }

    public String funcionarioMaiorBeneficio(Map<String, SalarioInfo> dados) {
        BigDecimal maiorBeneficio = BigDecimal.ZERO;
        String nomeMaiorBeneficio = "";
    
        for (SalarioInfo salarioInfo : dados.values()) {
            if (salarioInfo.getSalarioBeneficio().compareTo(maiorBeneficio) > 0) {
                maiorBeneficio = salarioInfo.getSalarioBeneficio();
                nomeMaiorBeneficio = salarioInfo.getNome();
            }
        }
        System.out.println("Maior benefício: " + nomeMaiorBeneficio);
        return nomeMaiorBeneficio;
    }

    public String funcionarioComMaisVendas(Map<String, SalarioInfo> dados) {
        BigDecimal maiorBeneficio = BigDecimal.ZERO;
        String nomeMaiorVendedor = "";
    
        for (SalarioInfo salarioInfo : dados.values()) {
            if (salarioInfo.getTotalEmVendas().compareTo(maiorBeneficio) > 0) {
                maiorBeneficio = salarioInfo.getTotalEmVendas();
                nomeMaiorVendedor = salarioInfo.getNome();
            }
        }
        System.out.println("Maior Vendedor: " + nomeMaiorVendedor);
        return nomeMaiorVendedor;
    }

}