package com.example.demo.Model;

public class Conducente {

    private int id;
    private String nome;
    private String cognome;
    private String username;
    private String password;
    private String email;

    // Costruttore vuoto per la deserializzazione
    public Conducente() {}

    // Costruttore con parametri
    public Conducente(int id, String nome, String cognome, String username, String password, String email) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCognome() { return cognome; }
    public void setCognome(String cognome) { this.cognome = cognome; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
