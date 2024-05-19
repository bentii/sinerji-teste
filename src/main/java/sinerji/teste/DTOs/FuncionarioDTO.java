package sinerji.teste.DTOs;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

import sinerji.teste.Models.Funcionario;

public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private CargoDTO cargo;
    private Date dataContratacao;
    private List<VendaDTO> vendas;

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public CargoDTO getCargo() {
        return cargo;
    }

    public Date getDataContratacao() {
        return dataContratacao;
    }

    public List<VendaDTO> getVendas() {
        return vendas;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(CargoDTO cargo) {
        this.cargo = cargo;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public void setVendas(List<VendaDTO> vendas) {
        this.vendas = vendas;
    }

    public static Funcionario toEntity(FuncionarioDTO dto) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId(dto.getId());
        funcionario.setNome(dto.getNome());
        funcionario.setDataContratacao(dto.getDataContratacao());
        funcionario.setCargo(CargoDTO.toEntity(dto.getCargo()));
        funcionario.setVendas(dto.getVendas().stream()
            .map(VendaDTO::toEntity)
            .collect(Collectors.toList()));
        return funcionario;
    }

    public static FuncionarioDTO fromEntity(Funcionario funcionario) {
        FuncionarioDTO dto = new FuncionarioDTO();
        dto.setId(funcionario.getId());
        dto.setNome(funcionario.getNome());
        dto.setDataContratacao(funcionario.getDataContratacao());
        dto.setCargo(CargoDTO.fromEntity(funcionario.getCargo()));
        dto.setVendas(funcionario.getVendas().stream()
            .map(VendaDTO::fromEntity)
            .collect(Collectors.toList()));
        return dto;
    }
}