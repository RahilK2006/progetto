package com.example.demo.Model;

public class BuonoDiConsegna {
    private int id;
    private int id_polizza;
    private int id_cliente;
    private double peso_riferito;
    private String data_emissione; // data come stringa

    // Costruttore vuoto
    public BuonoDiConsegna() {}

    // Costruttore completo
    public BuonoDiConsegna(int id, int id_polizza, int id_cliente, double peso_riferito, String data_emissione) {
        this.id = id;
        this.id_polizza = id_polizza;
        this.id_cliente = id_cliente;
        this.peso_riferito = peso_riferito;
        this.data_emissione = data_emissione;
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_polizza() {
        return id_polizza;
    }

    public void setId_polizza(int id_polizza) {
        this.id_polizza = id_polizza;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public double getPeso_riferito() {
        return peso_riferito;
    }

    public void setPeso_riferito(double peso_riferito) {
        this.peso_riferito = peso_riferito;
    }

    public String getData_emissione() {
        return data_emissione;
    }

    public void setData_emissione(String data_emissione) {
        this.data_emissione = data_emissione;
    }
}
