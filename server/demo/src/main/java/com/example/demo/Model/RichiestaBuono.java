package com.example.demo.Model;

public class RichiestaBuono {
    private int id;
    private int id_cliente;
    private int id_polizza;
    private double peso_richiesto;
    private String data_richiesta;
    private String stato; // enum: 'in attesa', 'approvata', 'rifiutata'

    public RichiestaBuono() {}

    public RichiestaBuono(int id, int id_cliente, int id_polizza, double peso_richiesto, String data_richiesta, String stato) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.id_polizza = id_polizza;
        this.peso_richiesto = peso_richiesto;
        this.data_richiesta = data_richiesta;
        this.stato = stato;
    }

    // getter e setter

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_cliente() { return id_cliente; }
    public void setId_cliente(int id_cliente) { this.id_cliente = id_cliente; }

    public int getId_polizza() { return id_polizza; }
    public void setId_polizza(int id_polizza) { this.id_polizza = id_polizza; }

    public double getPeso_richiesto() { return peso_richiesto; }
    public void setPeso_richiesto(double peso_richiesto) { this.peso_richiesto = peso_richiesto; }

    public String getData_richiesta() { return data_richiesta; }
    public void setData_richiesta(String data_richiesta) { this.data_richiesta = data_richiesta; }

    public String getStato() { return stato; }
    public void setStato(String stato) { this.stato = stato; }
}
