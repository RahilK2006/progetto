package com.example.demo.DAO;

import com.example.demo.Model.Porto;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PortoDao {

    public List<Porto> trovaTutti() {
        List<Porto> lista = new ArrayList<>();
        String sql = "SELECT * FROM porto";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Porto porto = new Porto(
                        rs.getInt("id"),
                        rs.getString("nome_porto"),
                        rs.getString("nazione"),
                        rs.getString("linea")
                );
                lista.add(porto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Porto trovaPerId(int id) {
        Porto porto = null;
        String sql = "SELECT * FROM porto WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                porto = new Porto(
                        rs.getInt("id"),
                        rs.getString("nome_porto"),
                        rs.getString("nazione"),
                        rs.getString("linea")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return porto;
    }

    public boolean inserisci(Porto porto) {
        String sql = "INSERT INTO porto (nome_porto, nazione, linea) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, porto.getNome_porto());
            stmt.setString(2, porto.getNazione());
            stmt.setString(3, porto.getLinea());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean elimina(int id) {
        String sql = "DELETE FROM porto WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aggiorna(Porto porto) {
        String sql = "UPDATE porto SET nome_porto = ?, nazione = ?, linea = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, porto.getNome_porto());
            stmt.setString(2, porto.getNazione());
            stmt.setString(3, porto.getLinea());
            stmt.setInt(4, porto.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
