package com.example.demo.DAO;
import com.example.demo.DAO.Utility;

import com.example.demo.Model.RichiestaBuono;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class RichiestaBuonoDao {

       public boolean inserisci(RichiestaBuono rb) {
        String sql = "INSERT INTO richiesta_buono (id_cliente, id_polizza, peso_richiesto) VALUES (?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rb.getId_cliente());
            stmt.setInt(2, rb.getId_polizza());
            stmt.setDouble(3, rb.getPeso_richiesto());


            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<RichiestaBuono> getByCliente(int idCliente) {
        List<RichiestaBuono> lista = new ArrayList<>();
        String sql = "SELECT * FROM richiesta_buono WHERE id_cliente = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idCliente);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RichiestaBuono rb = new RichiestaBuono(
                            rs.getInt("id"),
                            rs.getInt("id_cliente"),
                            rs.getInt("id_polizza"),
                            rs.getDouble("peso_richiesto"),
                            rs.getString("data_richiesta"),
                            rs.getString("stato")
                    );
                    lista.add(rb);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    public List<RichiestaBuono> getAll() {
        List<RichiestaBuono> lista = new ArrayList<>();
        String sql = "SELECT * FROM richiesta_buono";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                RichiestaBuono rb = new RichiestaBuono(
                        rs.getInt("id"),
                        rs.getInt("id_cliente"),
                        rs.getInt("id_polizza"),
                        rs.getDouble("peso_richiesto"),
                        rs.getString("data_richiesta"),
                        rs.getString("stato")
                );
                lista.add(rb);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    // Recupera tutte le richieste per una specifica polizza
    public List<RichiestaBuono> getByPolizza(int idPolizza) {
        List<RichiestaBuono> lista = new ArrayList<>();
        String sql = "SELECT * FROM richiesta_buono WHERE id_polizza = ?";

        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPolizza);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    RichiestaBuono rb = new RichiestaBuono(
                            rs.getInt("id"),
                            rs.getInt("id_cliente"),
                            rs.getInt("id_polizza"),
                            rs.getDouble("peso_richiesto"),
                            rs.getString("data_richiesta"),
                            rs.getString("stato")
                    );
                    lista.add(rb);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean aggiornaStato(int idRichiesta, String nuovoStato) {
    String sql = "UPDATE richiesta_buono SET stato = ? WHERE id = ?";
    try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD);
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, nuovoStato);
        stmt.setInt(2, idRichiesta);

        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

}
