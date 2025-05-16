package com.example.demo.Model;

public class Merce {
    private int id;
    private String tipologia;
    private int idFornitore;

    public Merce() {}

    public Merce(int id, String tipologia, int idFornitore) {
        this.id = id;
        this.tipologia = tipologia;
        this.idFornitore = idFornitore;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTipologia() { return tipologia; }
    public void setTipologia(String tipologia) { this.tipologia = tipologia; }

    public int getIdFornitore() { return idFornitore; }
    public void setIdFornitore(int idFornitore) { this.idFornitore = idFornitore; }
}
