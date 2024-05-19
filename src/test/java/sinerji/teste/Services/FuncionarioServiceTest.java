package sinerji.teste.Services;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import sinerji.teste.Models.SalarioInfo;
import sinerji.teste.Repositories.FuncionarioRepository;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FuncionarioServiceTest {

    @Test
    public void testValorTotalPagoMes() {
        FuncionarioRepository funcionarioRepository = Mockito.mock(FuncionarioRepository.class);

        FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepository);

        Map<String, SalarioInfo> dados = new HashMap<>();
        SalarioInfo salarioInfo1 = new SalarioInfo();
        salarioInfo1.setSalario(new BigDecimal("1000"));
        salarioInfo1.setSalarioBonus(new BigDecimal("200"));
        salarioInfo1.setSalarioBeneficio(new BigDecimal("300"));
        salarioInfo1.setSalarioTotal(new BigDecimal("1500"));
        dados.put("Funcionario1", salarioInfo1);

        SalarioInfo salarioInfo2 = new SalarioInfo();
        salarioInfo2.setSalario(new BigDecimal("2000"));
        salarioInfo2.setSalarioBonus(new BigDecimal("400"));
        salarioInfo2.setSalarioBeneficio(new BigDecimal("600"));
        salarioInfo2.setSalarioTotal(new BigDecimal("3000"));
        dados.put("Funcionario2", salarioInfo2);

        BigDecimal totalPago = funcionarioService.valorTotalPagoMes(dados);
        System.out.println("---------------------------------------------------Total pago: " + totalPago);
        assertEquals(new BigDecimal("4500"), totalPago);
    }
}