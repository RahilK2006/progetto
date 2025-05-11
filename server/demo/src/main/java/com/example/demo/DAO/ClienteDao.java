package com.example.demo.DAO;

import com.example.demo.Model.Cliente;
import com.example.demo.DAO.DbConnection;
import com.example.demo.DAO.Utility;

import java.sql.*;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteDao {

    // Metodo per recuperare tutti i clienti
    public List<Cliente> trovaTutti() {
        List<Cliente> lista = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM cliente";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Cliente u = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("azienda")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    // Metodo per recuperare un cliente per ID
    public Cliente trovaPerId(int id) {
        Cliente cliente = null;
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome"),
                        rs.getString("email"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("azienda")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;  // Restituisce null se non trovato
    }

    public Cliente login(String username, String password) {
        Cliente cliente = null;
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "SELECT * FROM cliente WHERE username = ? AND password = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, Utility.md5(password));

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rs.getString("azienda")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cliente;
    }


    // Metodo per inserire un nuovo cliente
    public boolean inserisci(Cliente cliente) {
        boolean success = false;
        try (Connection conn = DriverManager.getConnection(DbConnection.URL, DbConnection.USER, DbConnection.PASSWORD)) {
            String sql = "INSERT INTO cliente (nome, cognome, email, username, password, azienda) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCognome());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getUsername());
        stmt.setString(5, Utility.md5(cliente.getPassword())); 
            stmt.setString(6, cliente.getAzienda());
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                success = true;  // Cliente inserito correttamente
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return success;  // Restituisce true se inserito con successo, false altrimenti
    }
}
