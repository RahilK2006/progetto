package com.example.demo.DAO;

import com.example.demo.Model.Viaggio;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class ViaggioDao {

    public List<Viaggio> trovaTutti() {
        List<Viaggio> lista = new ArrayList<>();
        String sql = "SELECT * FROM viaggio";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Viaggio v = new Viaggio(
                        rs.getInt("id"),
                        rs.getInt("id_nave"),
                        rs.getInt("porto_partenza"),
                        rs.getInt("porto_arrivo"),
                        rs.getString("data_partenza"),
                        rs.getString("data_arrivo"),
                        rs.getInt("linea")
                );
                lista.add(v);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean inserisci(Viaggio v) {
        String sql = "INSERT INTO viaggio (id_nave, porto_partenza, porto_arrivo, data_partenza, data_arrivo, linea) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, v.getId_nave());
            stmt.setInt(2, v.getPorto_partenza());
            stmt.setInt(3, v.getPorto_arrivo());
            stmt.setString(4, v.getData_partenza());
            stmt.setString(5, v.getData_arrivo());
            stmt.setInt(6, v.getLinea());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean aggiorna(Viaggio v) {
        String sql = "UPDATE viaggio SET id_nave = ?, porto_partenza = ?, porto_arrivo = ?, data_partenza = ?, data_arrivo = ?, linea = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
            PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, v.getId_nave());
            stmt.setInt(2, v.getPorto_partenza());
            stmt.setInt(3, v.getPorto_arrivo());
            stmt.setString(4, v.getData_partenza());
            stmt.setString(5, v.getData_arrivo());
            stmt.setInt(6, v.getLinea());
            stmt.setInt(7, v.getId());

            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean elimina(int id) {
        String sql = "DELETE FROM viaggio WHERE id = ?";

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
