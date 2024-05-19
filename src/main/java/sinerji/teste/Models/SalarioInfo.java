package sinerji.teste.Models;

import java.math.BigDecimal;

public class SalarioInfo {
    private String nome;
    private BigDecimal salario;
    private BigDecimal salarioBonus;
    private BigDecimal salarioBeneficio;
    private BigDecimal salarioTotal;
    private BigDecimal totalEmVendas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getSalarioBonus() {
        return salarioBonus;
    }

    public void setSalarioBonus(BigDecimal salarioBonus) {
        this.salarioBonus = salarioBonus;
    }

    public BigDecimal getSalarioBeneficio() {
        return salarioBeneficio;
    }

    public void setSalarioBeneficio(BigDecimal salarioBeneficio) {
        this.salarioBeneficio = salarioBeneficio;
    }

    public BigDecimal getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(BigDecimal salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    public BigDecimal getTotalEmVendas() {
        return totalEmVendas;
    }

    public void setTotalEmVendas(BigDecimal totalEmVendas) {
        this.totalEmVendas = totalEmVendas;
    }
}