package com.progetto.DAO;


import com.progetto.models.BuonoDiConsegna;
import java.sql.*;

public class BuonoDiConsegnaDao {
    private final Connection connection;

    public BuonoDiConsegnaDao(Connection connection) {
        this.connection = connection;
    }

    public void insertBuono(BuonoDiConsegna buono) throws SQLException {
        String sql = "INSERT INTO buono_di_consegna (id_polizza, id_cliente, peso_riferito, data_emissione) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, buono.getIdPolizza());
            stmt.setInt(2, buono.getIdCliente());
            stmt.setDouble(3, buono.getPesoRiferito());
            stmt.setDate(4, new java.sql.Date(buono.getDataEmissione().getTime()));
            stmt.executeUpdate();
        }
    }
}
