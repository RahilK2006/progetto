package com.progetto.models;

import java.util.Date;

public class BuonoDiConsegna {
    private int id;
    private int idPolizza;
    private int idCliente;
    private double pesoRiferito;
    private Date dataEmissione;

    public BuonoDiConsegna() {}

    public BuonoDiConsegna(int id, int idPolizza, int idCliente, double pesoRiferito, Date dataEmissione) {
        this.id = id;
        this.idPolizza = idPolizza;
        this.idCliente = idCliente;
        this.pesoRiferito = pesoRiferito;
        this.dataEmissione = dataEmissione;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPolizza() { return idPolizza; }
    public void setIdPolizza(int idPolizza) { this.idPolizza = idPolizza; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public double getPesoRiferito() { return pesoRiferito; }
    public void setPesoRiferito(double pesoRiferito) { this.pesoRiferito = pesoRiferito; }

    public Date getDataEmissione() { return dataEmissione; }
    public void setDataEmissione(Date dataEmissione) { this.dataEmissione = dataEmissione; }
}