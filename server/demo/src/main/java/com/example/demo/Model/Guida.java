package com.example.demo.Model;


public class Guida {
    private int id;
    private int idConducente;
    private String idCamion;

    public Guida() {}

    public Guida(int id, int idConducente, String idCamion) {
        this.id = id;
        this.idConducente = idConducente;
        this.idCamion = idCamion;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdConducente() { return idConducente; }
    public void setIdConducente(int idConducente) { this.idConducente = idConducente; }

    public String getIdCamion() { return idCamion; }
    public void setIdCamion(String idCamion) { this.idCamion = idCamion; }
}
