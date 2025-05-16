package com.example.demo.Model;

public class PolizzaCarico {
    private int id;
    private int id_viaggio;
    private int id_fornitore;
    private int id_cliente;
    private int tipologia_merce;
    private double peso_totale;
    private int giorni_franchigia;
    private double tariffa_giornaliera;

    public PolizzaCarico() {}

    public PolizzaCarico(int id, int id_viaggio, int id_fornitore, int id_cliente, int tipologia_merce, double peso_totale, int giorni_franchigia, double tariffa_giornaliera) {
        this.id = id;
        this.id_viaggio = id_viaggio;
        this.id_fornitore = id_fornitore;
        this.id_cliente = id_cliente;
        this.tipologia_merce = tipologia_merce;
        this.peso_totale = peso_totale;
        this.giorni_franchigia = giorni_franchigia;
        this.tariffa_giornaliera = tariffa_giornaliera;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_viaggio() { return id_viaggio; }
    public void setId_viaggio(int id_viaggio) { this.id_viaggio = id_viaggio; }

    public int getId_fornitore() { return id_fornitore; }
    public void setId_fornitore(int id_fornitore) { this.id_fornitore = id_fornitore; }

    public int getId_cliente() { return id_cliente; }
    public void setId_cliente(int id_cliente) { this.id_cliente = id_cliente; }

    public int getTipologia_merce() { return tipologia_merce; }
    public void setTipologia_merce(int tipologia_merce) { this.tipologia_merce = tipologia_merce; }

    public double getPeso_totale() { return peso_totale; }
    public void setPeso_totale(double peso_totale) { this.peso_totale = peso_totale; }

    public int getGiorni_franchigia() { return giorni_franchigia; }
    public void setGiorni_franchigia(int giorni_franchigia) { this.giorni_franchigia = giorni_franchigia; }

    public double getTariffa_giornaliera() { return tariffa_giornaliera; }
    public void setTariffa_giornaliera(double tariffa_giornaliera) { this.tariffa_giornaliera = tariffa_giornaliera; }
}
