package com.example.demo.Model;


import java.util.Date;

public class Transazione {
    private int id;
    private int idPolizza;
    private int idCliente;
    private double importo;
    private Date dataOraPagamento;
    private String metodo;

    public Transazione() {}

    public Transazione(int id, int idPolizza, int idCliente, double importo, Date dataOraPagamento, String metodo) {
        this.id = id;
        this.idPolizza = idPolizza;
        this.idCliente = idCliente;
        this.importo = importo;
        this.dataOraPagamento = dataOraPagamento;
        this.metodo = metodo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdPolizza() { return idPolizza; }
    public void setIdPolizza(int idPolizza) { this.idPolizza = idPolizza; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public double getImporto() { return importo; }
    public void setImporto(double importo) { this.importo = importo; }

    public Date getDataOraPagamento() { return dataOraPagamento; }
    public void setDataOraPagamento(Date dataOraPagamento) { this.dataOraPagamento = dataOraPagamento; }

    public String getMetodo() { return metodo; }
    public void setMetodo(String metodo) { this.metodo = metodo; }
}
