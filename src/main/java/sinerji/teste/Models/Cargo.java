package sinerji.teste.Models;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "salario")
    private BigDecimal salario;

    @Column(name = "salario_bonus")
    private BigDecimal salarioBonus;

    @Column(name = "beneficio")
    private BigDecimal beneficio;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public void setSalarioBonus(BigDecimal salarioBonus) {
        this.salarioBonus = salarioBonus;
    }

    public void setBeneficio(BigDecimal beneficio) {
        this.beneficio = beneficio;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public BigDecimal getSalario() {
        return this.salario;
    }

    public BigDecimal getSalarioBonus() {
        return this.salarioBonus;
    }

    public BigDecimal getBeneficio() {
        return this.beneficio;
    }
}