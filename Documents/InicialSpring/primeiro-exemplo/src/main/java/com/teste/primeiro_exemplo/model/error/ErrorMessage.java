package com.teste.primeiro_exemplo.model.error;

public class ErrorMessage {

    private  String titulo;
    private Integer status;
    private String mensagemDeErro;




    
    public ErrorMessage(String titulo, Integer status, String mensagemDeErro) {
        this.titulo = titulo;
        this.status = status;
        this.mensagemDeErro = mensagemDeErro;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getMensagemDeErro() {
        return mensagemDeErro;
    }
    public void setMensagemDeErro(String mensagemDeErro) {
        this.mensagemDeErro = mensagemDeErro;
    }


    

    
}
