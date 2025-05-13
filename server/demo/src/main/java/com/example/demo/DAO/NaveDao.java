package com.example.demo.DAO;

import com.example.demo.Model.Nave;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class NaveDao {

    // Recupera tutte le navi
    public List<Nave> trovaTutte() {
        List<Nave> lista = new ArrayList<>();
        String sql = "SELECT * FROM nave";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Nave nave = new Nave(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
                lista.add(nave);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // Recupera una nave per ID
    public Nave trovaPerId(int id) {
        Nave nave = null;
        String sql = "SELECT * FROM nave WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                nave = new Nave(
                        rs.getInt("id"),
                        rs.getString("nome")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nave;
    }

    // Inserisce una nuova nave
    public boolean inserisci(Nave nave) {
        boolean success = false;
        String sql = "INSERT INTO nave (nome) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nave.getNome());
            int rows = stmt.executeUpdate();
            success = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Elimina una nave per ID
    public boolean elimina(int id) {
        boolean success = false;
        String sql = "DELETE FROM nave WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int rows = stmt.executeUpdate();
            success = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }

    // Aggiorna una nave esistente
    public boolean aggiorna(Nave nave) {
        boolean success = false;
        String sql = "UPDATE nave SET nome = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nave.getNome());
            stmt.setInt(2, nave.getId());
            int rows = stmt.executeUpdate();
            success = rows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
}
