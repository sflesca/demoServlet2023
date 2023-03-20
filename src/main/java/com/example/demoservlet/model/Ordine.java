package com.example.demoservlet.model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Date;

@Entity
public class Ordine {
    @GeneratedValue
    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @ManyToOne(optional = false)
    private Cliente cliente;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @OneToMany(fetch = FetchType.EAGER)
    private Collection<DettaglioOrdine> dettagli;

    public Collection<DettaglioOrdine> getDettagli() {
        return dettagli;
    }

    public void setDettagli(Collection<DettaglioOrdine> dettagli) {
        this.dettagli = dettagli;
    }
}
