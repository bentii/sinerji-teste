package sinerji.teste.DTOs;
import java.math.BigDecimal;

import sinerji.teste.Models.Cargo;

public class CargoDTO {
    private Integer id;
    private String nome;
    private BigDecimal salario;
    private BigDecimal salarioBonus;
    private BigDecimal beneficio;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public BigDecimal getSalarioBonus() {
        return salarioBonus;
    }

    public BigDecimal getBeneficio() {
        return beneficio;
    }

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

    
    public static Cargo toEntity(CargoDTO dto) {
        Cargo cargo = new Cargo();
        cargo.setId(dto.getId());
        cargo.setNome(dto.getNome());
        cargo.setSalario(dto.getSalario());
        cargo.setSalarioBonus(dto.getSalarioBonus());
        cargo.setBeneficio(dto.getBeneficio());
        return cargo;
    }

    public static CargoDTO fromEntity(Cargo cargo) {
        CargoDTO dto = new CargoDTO();
        dto.setId(cargo.getId());
        dto.setNome(cargo.getNome());
        dto.setSalario(cargo.getSalario());
        dto.setSalarioBonus(cargo.getSalarioBonus());
        dto.setBeneficio(cargo.getBeneficio());
        return dto;
    }
}