package com.example.demo.DAO;

import com.example.demo.Model.Linea;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LineaDao {

    public List<Linea> trovaTutti() {
        List<Linea> lista = new ArrayList<>();
        String sql = "SELECT * FROM linea";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Linea linea = new Linea(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
                lista.add(linea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public Linea trovaPerId(int id) {
        Linea linea = null;
        String sql = "SELECT * FROM linea WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                linea = new Linea(
                    rs.getInt("id"),
                    rs.getString("nome")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return linea;
    }

    public boolean inserisci(Linea linea) {
        String sql = "INSERT INTO linea (nome) VALUES (?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, linea.getNome());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aggiorna(Linea linea) {
        String sql = "UPDATE linea SET nome = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, linea.getNome());
            stmt.setInt(2, linea.getId());
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean elimina(int id) {
        String sql = "DELETE FROM linea WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
