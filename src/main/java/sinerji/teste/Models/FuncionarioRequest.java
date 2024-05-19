package sinerji.teste.Models;

import java.util.List;

public class FuncionarioRequest {
    private List<String> nomes;
    private String data;
    private String metodo;

    public List<String> getNomes() {
        return nomes;
    }

    public String getData() {
        return data;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setNomes(List<String> nomes) {
        this.nomes = nomes;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
}