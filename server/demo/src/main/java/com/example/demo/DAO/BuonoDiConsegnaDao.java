package com.example.demo.DAO;

import com.example.demo.Model.BuonoDiConsegna;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class BuonoDiConsegnaDao {

    // Inserisce un nuovo buono
    public boolean creaBuono(int idPolizza, int idCliente, double pesoRiferito) {
        boolean success = false;
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO buono_di_consegna (id_polizza, id_cliente, peso_riferito, data_emissione) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idPolizza);
            stmt.setInt(2, idCliente);
            stmt.setDouble(3, pesoRiferito);
            stmt.setString(4, LocalDateTime.now().toString()); // salva come stringa
            int rowsAffected = stmt.executeUpdate();
            success = rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;
    }

    // Ritorna tutti i buoni di consegna
    public List<BuonoDiConsegna> trovaTutti() {
        List<BuonoDiConsegna> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM buono_di_consegna ORDER BY data_emissione DESC";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                BuonoDiConsegna b = new BuonoDiConsegna(
                    rs.getInt("id"),
                    rs.getInt("id_polizza"),
                    rs.getInt("id_cliente"),
                    rs.getDouble("peso_riferito"),
                    rs.getString("data_emissione")
                );
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Trova buoni per cliente
    public List<BuonoDiConsegna> trovaPerCliente(int idCliente) {
        List<BuonoDiConsegna> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM buono_di_consegna WHERE id_cliente = ? ORDER BY data_emissione DESC";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, idCliente);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                BuonoDiConsegna b = new BuonoDiConsegna(
                    rs.getInt("id"),
                    rs.getInt("id_polizza"),
                    rs.getInt("id_cliente"),
                    rs.getDouble("peso_riferito"),
                    rs.getString("data_emissione")
                );
                lista.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
