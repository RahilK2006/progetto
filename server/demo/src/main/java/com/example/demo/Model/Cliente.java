package com.example.demo.Model;

public class Cliente {
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String username;
    private String password;
    private String azienda;

    public Cliente() {}

    public Cliente(int id, String nome, String cognome, String email, String username, String password, String azienda) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.username = username;
        this.password = password;
        this.azienda = azienda;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAzienda() { return azienda; }
    public void setAzienda(String azienda) { this.azienda = azienda; }
}
