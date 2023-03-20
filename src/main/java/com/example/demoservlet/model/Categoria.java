package com.example.demoservlet.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.LinkedList;

@Entity
public class Categoria {
    @Basic
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "categoria")
    private Collection<Prodotto> prodotti = new LinkedList<>();

    public Collection<Prodotto> getProdotti() {
        return prodotti;
    }

    public void setProdotti(Collection<Prodotto> prodotti) {
        this.prodotti = prodotti;
    }
}
