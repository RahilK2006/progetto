package com.progetto.DAO;

import com.progetto.models.Viaggio;
import java.sql.*;

public class ViaggioDao {
    private final Connection connection;

    public ViaggioDao(Connection connection) {
        this.connection = connection;
    }

    public Viaggio getById(int id) throws SQLException {
        String sql = "SELECT * FROM viaggio WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Viaggio(
                    rs.getInt("id"),
                    rs.getInt("id_nave"),
                    rs.getInt("porto_partenza"),
                    rs.getInt("porto_arrivo"),
                    rs.getDate("data_partenza"),
                    rs.getDate("data_arrivo")
                );
            }
        }
        return null;
    }
}
