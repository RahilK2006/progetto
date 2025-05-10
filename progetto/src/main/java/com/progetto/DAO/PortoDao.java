package com.progetto.DAO;


import com.progetto.models.Porto;
import java.sql.*;

public class PortoDao {
    private final Connection connection;

    public PortoDao(Connection connection) {
        this.connection = connection;
    }

    public Porto getById(int id) throws SQLException {
        String sql = "SELECT * FROM porto WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Porto(
                    rs.getInt("id"),
                    rs.getString("nome_porto"),
                    rs.getString("nazione"),
                    rs.getString("linea")
                );
            }
        }
        return null;
    }
}
