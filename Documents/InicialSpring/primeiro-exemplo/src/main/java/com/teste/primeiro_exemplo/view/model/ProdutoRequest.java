package com.teste.primeiro_exemplo.view.model;

public class ProdutoRequest {
   

    private String nome;

    private double valor;

    private String descricao;
    
    private Integer quantidade; 

    //#endregion

    //#region Getters e Setters
   



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
}
