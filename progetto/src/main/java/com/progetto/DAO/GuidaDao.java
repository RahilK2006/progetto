package com.progetto.DAO;


import com.progetto.models.Guida;
import java.sql.*;

public class GuidaDao {
    private final Connection connection;

    public GuidaDao(Connection connection) {
        this.connection = connection;
    }

    public void insertGuida(Guida guida) throws SQLException {
        String sql = "INSERT INTO guida (id_conducente, id_camion) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, guida.getIdConducente());
            stmt.setString(2, guida.getIdCamion());
            stmt.executeUpdate();
        }
    }
}
