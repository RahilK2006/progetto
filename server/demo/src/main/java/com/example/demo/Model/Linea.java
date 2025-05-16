package com.example.demo.Model;

public class Linea {
    private int id;
    private String nome;

    public Linea() {}

    public Linea(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
}
