package com.progetto.models;


public class Porto {
    private int id;
    private String nomePorto;
    private String nazione;
    private String linea;

    public Porto() {}

    public Porto(int id, String nomePorto, String nazione, String linea) {
        this.id = id;
        this.nomePorto = nomePorto;
        this.nazione = nazione;
        this.linea = linea;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNomePorto() { return nomePorto; }
    public void setNomePorto(String nomePorto) { this.nomePorto = nomePorto; }

    public String getNazione() { return nazione; }
    public void setNazione(String nazione) { this.nazione = nazione; }

    public String getLinea() { return linea; }
    public void setLinea(String linea) { this.linea = linea; }
}

