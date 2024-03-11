package com.example.demoservlet.model;

import jakarta.persistence.*;

@Entity
@NamedQueries({@NamedQuery(name="getProva", query="select p from ProvaEntity p")})
public class ProvaEntity {
    @Id
    @GeneratedValue
    private long id;

    private String nome;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    @Version
    private long version;
}
