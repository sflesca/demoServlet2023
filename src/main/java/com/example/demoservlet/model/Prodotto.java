package com.example.demoservlet.model;

public class Prodotto {
    private int id;

    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public Prodotto(int id, String nome, double prezzo) {
        this.id = id;
        this.nome = nome;
        this.prezzo = prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private double prezzo;

    public Prodotto() {

    }
}
