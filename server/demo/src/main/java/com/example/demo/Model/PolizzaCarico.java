package com.example.demo.Model;


public class PolizzaCarico {
    private int id;
    private int idViaggio;
    private int idFornitore;
    private String tipologiaMerce;
    private double pesoTotale;
    private double giorniFranchigia;
    private double tariffaGiornaliera;

    public PolizzaCarico() {}

    public PolizzaCarico(int id, int idViaggio, int idFornitore, String tipologiaMerce, double pesoTotale, double giorniFranchigia, double tariffaGiornaliera) {
        this.id = id;
        this.idViaggio = idViaggio;
        this.idFornitore = idFornitore;
        this.tipologiaMerce = tipologiaMerce;
        this.pesoTotale = pesoTotale;
        this.giorniFranchigia = giorniFranchigia;
        this.tariffaGiornaliera = tariffaGiornaliera;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdViaggio() { return idViaggio; }
    public void setIdViaggio(int idViaggio) { this.idViaggio = idViaggio; }

    public int getIdFornitore() { return idFornitore; }
    public void setIdFornitore(int idFornitore) { this.idFornitore = idFornitore; }

    public String getTipologiaMerce() { return tipologiaMerce; }
    public void setTipologiaMerce(String tipologiaMerce) { this.tipologiaMerce = tipologiaMerce; }

    public double getPesoTotale() { return pesoTotale; }
    public void setPesoTotale(double pesoTotale) { this.pesoTotale = pesoTotale; }

    public double getGiorniFranchigia() { return giorniFranchigia; }
    public void setGiorniFranchigia(double giorniFranchigia) { this.giorniFranchigia = giorniFranchigia; }

    public double getTariffaGiornaliera() { return tariffaGiornaliera; }
    public void setTariffaGiornaliera(double tariffaGiornaliera) { this.tariffaGiornaliera = tariffaGiornaliera; }
}
