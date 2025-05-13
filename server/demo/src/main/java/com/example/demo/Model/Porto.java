package com.example.demo.Model;


public class Porto {
    private int id;
    private String nome_porto;
    private String nazione;
    private String linea;

    public Porto() {}

    public Porto(int id, String nomePorto, String nazione, String linea) {
        this.id = id;
        this.nome_porto = nomePorto;
        this.nazione = nazione;
        this.linea = linea;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome_porto() { return nome_porto; }
    public void setNomePorto(String nome_porto) { this.nome_porto = nome_porto; }

    public String getNazione() { return nazione; }
    public void setNazione(String nazione) { this.nazione = nazione; }

    public String getLinea() { return linea; }
    public void setLinea(String linea) { this.linea = linea; }
}

