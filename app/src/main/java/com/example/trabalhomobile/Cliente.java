package com.example.trabalhomobile;
public class Cliente {
    String nome, endereco, complemento, cidade, matricula, numero;


    public Cliente(String nome, String matricula, String endereco, String complemento, String cidade, String numero) {
        this.nome = nome;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.matricula = matricula;
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Cliente getCliente(){
        return this;
    }
}

