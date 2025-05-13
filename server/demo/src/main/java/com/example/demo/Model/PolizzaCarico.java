package com.example.demo.Model;


public class PolizzaCarico {
    private int id;
    private int id_viaggio;
    private int id_fornitore;
    private int tipologia_merce;
    private double peso_totale;
    private double giorni_franchigia;
    private double tariffa_giornaliera;

    public PolizzaCarico() {}

    public PolizzaCarico(int id, int idViaggio, int idFornitore, int tipologiaMerce, double pesoTotale, double giorniFranchigia, double tariffaGiornaliera) {
        this.id = id;
        this.id_viaggio = idViaggio;
        this.id_fornitore = idFornitore;
        this.tipologia_merce = tipologiaMerce;
        this.peso_totale = pesoTotale;
        this.giorni_franchigia = giorniFranchigia;
        this.tariffa_giornaliera = tariffaGiornaliera;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_viaggio() { return id_viaggio; }
    public void setId_viaggio(int idViaggio) { this.id_viaggio = idViaggio; }

    public int getId_fornitore() { return id_fornitore; }
    public void setId_fornitore(int idFornitore) { this.id_fornitore = idFornitore; }

    public int getTipologia_merce() { return tipologia_merce; }
    public void setTipologiaMerce(int tipologiaMerce) { this.tipologia_merce = tipologiaMerce; }

    public double getPeso_totale() { return peso_totale; }
    public void setPeso_totale(double pesoTotale) { this.peso_totale = pesoTotale; }

    public double getGiorni_franchigia() { return giorni_franchigia; }
    public void setGiorni_franchigia(double giorniFranchigia) { this.giorni_franchigia = giorniFranchigia; }

    public double getTariffa_giornaliera() { return tariffa_giornaliera; }
    public void setTariffa_giornaliera(double tariffaGiornaliera) { this.tariffa_giornaliera = tariffaGiornaliera; }
}
