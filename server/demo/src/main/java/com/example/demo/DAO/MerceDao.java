package com.example.demo.DAO;

import com.example.demo.Model.Merce;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MerceDao {

    public List<Merce> trovaPerFornitore(int idFornitore) {
        List<Merce> lista = new ArrayList<>();
        String sql = "SELECT * FROM merce WHERE idFornitore = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idFornitore);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                lista.add(new Merce(
                    rs.getInt("id"),
                    rs.getString("tipologia"),
                    rs.getInt("idFornitore")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean inserisci(Merce merce) {
        String sql = "INSERT INTO merce (tipologia, idFornitore) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, merce.getTipologia());
            stmt.setInt(2, merce.getIdFornitore());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aggiorna(Merce merce) {
        String sql = "UPDATE merce SET tipologia = ? WHERE id = ? AND idFornitore = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, merce.getTipologia());
            stmt.setInt(2, merce.getId());
            stmt.setInt(3, merce.getIdFornitore());
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean elimina(int id, int idFornitore) {
        String sql = "DELETE FROM merce WHERE id = ? AND idFornitore = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setInt(2, idFornitore);
            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
