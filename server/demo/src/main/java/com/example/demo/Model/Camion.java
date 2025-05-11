package com.progetto.models;


public class Camion {
    private String targa;

    public Camion() {}

    public Camion(String targa) {
        this.targa = targa;
    }

    public String getTarga() { return targa; }
    public void setTarga(String targa) { this.targa = targa; }
}
