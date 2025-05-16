package com.example.demo.DAO;

import com.example.demo.Model.PolizzaCarico;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PolizzaCaricoDao {

    public boolean inserisci(PolizzaCarico p) {
        String sql = "INSERT INTO polizzacarico (id_viaggio, id_fornitore, id_cliente, tipologia_merce, peso_totale, giorni_franchigia, tariffa_giornaliera) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getId_viaggio());
            stmt.setInt(2, p.getId_fornitore());
            stmt.setInt(3, p.getId_cliente());
            stmt.setInt(4, p.getTipologia_merce());
            stmt.setDouble(5, p.getPeso_totale());
            stmt.setInt(6, p.getGiorni_franchigia());
            stmt.setDouble(7, p.getTariffa_giornaliera());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<PolizzaCarico> getAll() {
        List<PolizzaCarico> lista = new ArrayList<>();
        String sql = "SELECT * FROM polizzacarico";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                PolizzaCarico p = new PolizzaCarico(
                        rs.getInt("id"),
                        rs.getInt("id_viaggio"),
                        rs.getInt("id_fornitore"),
                        rs.getInt("id_cliente"),
                        rs.getInt("tipologia_merce"),
                        rs.getDouble("peso_totale"),
                        rs.getInt("giorni_franchigia"),
                        rs.getDouble("tariffa_giornaliera")
                );
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public List<PolizzaCarico> trovaPerFornitore(int idFornitore) {
        List<PolizzaCarico> lista = new ArrayList<>();
        String sql = "SELECT * FROM polizzacarico WHERE id_fornitore = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
                PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1, idFornitore);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        PolizzaCarico p = new PolizzaCarico(
                                rs.getInt("id"),
                                rs.getInt("id_viaggio"),
                                rs.getInt("id_fornitore"),
                                rs.getInt("id_cliente"),
                                rs.getInt("tipologia_merce"),
                                rs.getDouble("peso_totale"),
                                rs.getInt("giorni_franchigia"),
                                rs.getDouble("tariffa_giornaliera")
                        );
                        lista.add(p);
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        return lista;
    }

    public List<PolizzaCarico> trovaPerCliente(int idCliente) {
    List<PolizzaCarico> lista = new ArrayList<>();
    String sql = "SELECT * FROM polizzacarico WHERE id_cliente = ?";

    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, idCliente);
        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PolizzaCarico p = new PolizzaCarico(
                        rs.getInt("id"),
                        rs.getInt("id_viaggio"),
                        rs.getInt("id_fornitore"),
                        rs.getInt("id_cliente"),
                        rs.getInt("tipologia_merce"),
                        rs.getDouble("peso_totale"),
                        rs.getInt("giorni_franchigia"),
                        rs.getDouble("tariffa_giornaliera")
                );
                lista.add(p);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return lista;
}
}
