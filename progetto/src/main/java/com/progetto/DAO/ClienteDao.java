package com.progetto.DAO;

import com.progetto.models.Cliente;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ClienteDao {

    private final Connection connection;

    public ClienteDao(Connection connection) {
        this.connection = connection;
    }

    public Cliente getByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM cliente WHERE email = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, email);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Cliente(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("email"),
                    rs.getString("password"),
                    rs.getString("tipo")
                );
            }
        }
        return null;
    }

    public static String md5(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] hashBytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }

    public boolean loginn(String email, String password) throws SQLException {
        Cliente cliente = getByEmail(email);
        if (cliente != null) {
            return cliente.getPassword().equals(md5(password));
        }
        return false;
    }

    public void insertCliente(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, email, password, tipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEmail());
            stmt.setString(3, md5(cliente.getPassword())); 
            stmt.setString(4, cliente.getTipo());
            stmt.executeUpdate();
        }
    }

}
