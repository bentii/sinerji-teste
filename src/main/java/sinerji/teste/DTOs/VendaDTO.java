package sinerji.teste.DTOs;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import sinerji.teste.Models.Venda;

public class VendaDTO {
    private Integer id;
    @JsonIgnore
    private FuncionarioDTO funcionario;
    private Date dataVenda;
    private BigDecimal valorTotal;

    public Integer getId() {
        return id;
    }

    public FuncionarioDTO getFuncionario() {
        return funcionario;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFuncionario(FuncionarioDTO funcionario) {
        this.funcionario = funcionario;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public static Venda toEntity(VendaDTO dto) {
        Venda venda = new Venda();
        venda.setId(dto.getId());
        venda.setDataVenda(dto.getDataVenda());
        venda.setValorTotal(dto.getValorTotal());

        return venda;
    }

    public static VendaDTO fromEntity(Venda venda) {
        VendaDTO dto = new VendaDTO();
        dto.setId(venda.getId());
        dto.setDataVenda(venda.getDataVenda());
        dto.setValorTotal(venda.getValorTotal());

        return dto;
    }

}