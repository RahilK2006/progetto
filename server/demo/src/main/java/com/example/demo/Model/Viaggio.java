package com.example.demo.Model;


import java.util.Date;

public class Viaggio {
    private int id;
    private int idNave;
    private int portoPartenza;
    private int portoArrivo;
    private Date dataPartenza;
    private Date dataArrivo;

    public Viaggio() {}

    public Viaggio(int id, int idNave, int portoPartenza, int portoArrivo, Date dataPartenza, Date dataArrivo) {
        this.id = id;
        this.idNave = idNave;
        this.portoPartenza = portoPartenza;
        this.portoArrivo = portoArrivo;
        this.dataPartenza = dataPartenza;
        this.dataArrivo = dataArrivo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getIdNave() { return idNave; }
    public void setIdNave(int idNave) { this.idNave = idNave; }

    public int getPortoPartenza() { return portoPartenza; }
    public void setPortoPartenza(int portoPartenza) { this.portoPartenza = portoPartenza; }

    public int getPortoArrivo() { return portoArrivo; }
    public void setPortoArrivo(int portoArrivo) { this.portoArrivo = portoArrivo; }

    public Date getDataPartenza() { return dataPartenza; }
    public void setDataPartenza(Date dataPartenza) { this.dataPartenza = dataPartenza; }

    public Date getDataArrivo() { return dataArrivo; }
    public void setDataArrivo(Date dataArrivo) { this.dataArrivo = dataArrivo; }
}
