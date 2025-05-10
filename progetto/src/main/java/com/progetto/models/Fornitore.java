package com.progetto.models;


public class Fornitore {
    private int id;
    private String nome;

    public Fornitore() {}

    public Fornitore(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
