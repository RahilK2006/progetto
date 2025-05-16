package com.example.demo.Model;

public class Viaggio {
    private int id;
    private int id_nave;
    private int porto_partenza;
    private int porto_arrivo;
    private String data_partenza;
    private String data_arrivo;
    private int linea;

    public Viaggio() {}

    public Viaggio(int id, int id_nave, int porto_partenza, int porto_arrivo, String data_partenza, String data_arrivo, int linea) {
        this.id = id;
        this.id_nave = id_nave;
        this.porto_partenza = porto_partenza;
        this.porto_arrivo = porto_arrivo;
        this.data_partenza = data_partenza;
        this.data_arrivo = data_arrivo;
        this.linea = linea;
    }

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getId_nave() { return id_nave; }
    public void setId_nave(int id_nave) { this.id_nave = id_nave; }

    public int getPorto_partenza() { return porto_partenza; }
    public void setPorto_partenza(int porto_partenza) { this.porto_partenza = porto_partenza; }

    public int getPorto_arrivo() { return porto_arrivo; }
    public void setPorto_arrivo(int porto_arrivo) { this.porto_arrivo = porto_arrivo; }

    public String getData_partenza() { return data_partenza; }
    public void setData_partenza(String data_partenza) { this.data_partenza = data_partenza; }

    public String getData_arrivo() { return data_arrivo; }
    public void setData_arrivo(String data_arrivo) { this.data_arrivo = data_arrivo; }

    public int getLinea() { return linea; }
    public void setLinea(int linea) { this.linea = linea; }
}
