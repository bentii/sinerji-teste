package sinerji.teste.Models;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "funcionario")
@NamedEntityGraph(name = "Funcionario.vendasAndCargo", attributeNodes = {
        @NamedAttributeNode("vendas"),
        @NamedAttributeNode("cargo")
})
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "cargo_id", nullable = false)
    private Cargo cargo;

    @Column(name = "data_contratacao")
    @Temporal(TemporalType.DATE)
    private Date dataContratacao;

    @JsonManagedReference
    @OneToMany(mappedBy = "funcionario", cascade = CascadeType.ALL)
    private List<Venda> vendas = new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public void setDataContratacao(Date dataContratacao) {
        this.dataContratacao = dataContratacao;
    }

    public void setVendas(List<Venda> vendas) {
        this.vendas = vendas;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public Cargo getCargo() {
        return this.cargo;
    }

    public Date getDataContratacao() {
        return this.dataContratacao;
    }

    public List<Venda> getVendas() {
        return this.vendas;
    }
}