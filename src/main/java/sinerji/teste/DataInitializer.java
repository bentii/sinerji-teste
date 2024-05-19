package sinerji.teste;

import sinerji.teste.Models.Cargo;
import sinerji.teste.Models.Funcionario;
import sinerji.teste.Models.Venda;
import sinerji.teste.Repositories.CargoRepository;
import sinerji.teste.Repositories.FuncionarioRepository;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;

@Component
public class DataInitializer {

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostConstruct
    public void initData() {
        Cargo secretario = new Cargo();
        secretario.setNome("Secretario");
        secretario.setSalario(new BigDecimal("7000.00"));
        secretario.setSalarioBonus(new BigDecimal("1000.00"));
        secretario.setBeneficio(new BigDecimal("20.00"));

        Cargo vendedor = new Cargo();
        vendedor.setNome("Vendedor");
        vendedor.setSalario(new BigDecimal("12000.00"));
        vendedor.setSalarioBonus(new BigDecimal("1800.00"));
        vendedor.setBeneficio(new BigDecimal("30.00"));

        Cargo gerente = new Cargo();
        gerente.setNome("Gerente");
        gerente.setSalario(new BigDecimal("20000.00"));
        gerente.setSalarioBonus(new BigDecimal("3000.00"));
        gerente.setBeneficio(null);

        cargoRepository.saveAll(Arrays.asList(secretario, vendedor, gerente));

        Funcionario funcionario01 = new Funcionario();
        funcionario01.setNome("Jorge Carvalho");
        funcionario01.setCargo(secretario);
        funcionario01.setDataContratacao(java.sql.Date.valueOf("2018-01-01"));

        Funcionario funcionario02 = new Funcionario();
        funcionario02.setNome("Maria Souza");
        funcionario02.setCargo(secretario);
        funcionario02.setDataContratacao(java.sql.Date.valueOf("2015-12-01"));

        Funcionario funcionario03 = new Funcionario();
        funcionario03.setNome("Ana Silva");
        funcionario03.setCargo(vendedor);
        funcionario03.setDataContratacao(java.sql.Date.valueOf("2021-12-01"));

        List<Venda> vendasFuncionario03 = new ArrayList<>();
        Venda venda01 = new Venda();
        venda01.setDataVenda(java.sql.Date.valueOf("2021-12-01"));
        venda01.setValorTotal(new BigDecimal("5200.00"));
        venda01.setFuncionario(funcionario03);
        vendasFuncionario03.add(venda01);
        Venda venda02 = new Venda();
        venda02.setDataVenda(java.sql.Date.valueOf("2022-01-01"));
        venda02.setValorTotal(new BigDecimal("4000.00"));
        venda02.setFuncionario(funcionario03);
        vendasFuncionario03.add(venda02);
        Venda venda03 = new Venda();
        venda03.setDataVenda(java.sql.Date.valueOf("2022-02-01"));
        venda03.setValorTotal(new BigDecimal("4200.00"));
        venda03.setFuncionario(funcionario03);
        vendasFuncionario03.add(venda03);
        Venda venda04 = new Venda();
        venda04.setDataVenda(java.sql.Date.valueOf("2022-03-01"));
        venda04.setValorTotal(new BigDecimal("5850.00"));
        venda04.setFuncionario(funcionario03);
        vendasFuncionario03.add(venda04);
        Venda venda05 = new Venda();
        venda05.setDataVenda(java.sql.Date.valueOf("2022-04-01"));
        venda05.setValorTotal(new BigDecimal("7000.00"));
        venda05.setFuncionario(funcionario03);
        vendasFuncionario03.add(venda05);

        funcionario03.setVendas(vendasFuncionario03);

        Funcionario funcionario04 = new Funcionario();
        funcionario04.setNome("João Mendes");
        funcionario04.setCargo(vendedor);
        funcionario04.setDataContratacao(java.sql.Date.valueOf("2021-12-01"));

        List<Venda> vendasFuncionario04 = new ArrayList<>();
        Venda venda06 = new Venda();
        venda06.setDataVenda(java.sql.Date.valueOf("2021-12-01"));
        venda06.setValorTotal(new BigDecimal("3400.00"));
        venda06.setFuncionario(funcionario04);
        vendasFuncionario04.add(venda06);
        Venda venda07 = new Venda();
        venda07.setDataVenda(java.sql.Date.valueOf("2022-01-01"));
        venda07.setValorTotal(new BigDecimal("7700.00"));
        venda07.setFuncionario(funcionario04);
        vendasFuncionario04.add(venda07);
        Venda venda08 = new Venda();
        venda08.setDataVenda(java.sql.Date.valueOf("2022-02-01"));
        venda08.setValorTotal(new BigDecimal("5000.00"));
        venda08.setFuncionario(funcionario04);
        vendasFuncionario04.add(venda08);
        Venda venda09 = new Venda();
        venda09.setDataVenda(java.sql.Date.valueOf("2022-03-01"));
        venda09.setValorTotal(new BigDecimal("5900.00"));
        venda09.setFuncionario(funcionario04);
        vendasFuncionario04.add(venda09);
        Venda venda10 = new Venda();
        venda10.setDataVenda(java.sql.Date.valueOf("2022-04-01"));
        venda10.setValorTotal(new BigDecimal("6500.00"));
        venda10.setFuncionario(funcionario04);
        vendasFuncionario04.add(venda10);

        funcionario04.setVendas(vendasFuncionario04);

        Funcionario funcionario05 = new Funcionario();
        funcionario05.setNome("Juliana Alves");
        funcionario05.setCargo(gerente);
        funcionario05.setDataContratacao(java.sql.Date.valueOf("2017-07-01"));

        Funcionario funcionario06 = new Funcionario();
        funcionario06.setNome("Bento Albino");
        funcionario06.setCargo(gerente);
        funcionario06.setDataContratacao(java.sql.Date.valueOf("2014-03-01"));

        funcionarioRepository.saveAll(Arrays.asList(
                funcionario01, funcionario02, funcionario03, funcionario04, funcionario05, funcionario06));

    }
}
