package sinerji.teste.Models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "venda")
public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "funcionario_id")
    private Funcionario funcionario;

    @Column(name = "data_venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Integer getId() {
        return this.id;
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    public Date getDataVenda() {
        return this.dataVenda;
    }

    public BigDecimal getValorTotal() {
        return this.valorTotal;
    }
}