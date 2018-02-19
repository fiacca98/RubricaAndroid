package com.example.luigi.rubricatelefonica;

/**
 * Created by luigi on 15/02/2018.
 */

public class Contatto {

    private String nome;
    private String numero;
    public Contatto(String nome, String numero){
        this.setNome(nome);
        this.setNumero(numero);
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setNumero(String numero){
        this.numero = numero;
    }
    public String getNome(){
        return this.nome;
    }
    public String getNumero(){
        return this.numero;
    }
}
