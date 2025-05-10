package com.progetto.DAO;


import com.progetto.models.Transazione;
import java.sql.*;

public class TransazioneDao {
    private final Connection connection;

    public TransazioneDao(Connection connection) {
        this.connection = connection;
    }

    public void insertTransazione(Transazione transazione) throws SQLException {
        String sql = "INSERT INTO transazione (id_polizza, id_cliente, importo, data_ora_pagamento, metodo_pagamento) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transazione.getIdPolizza());
            stmt.setInt(2, transazione.getIdCliente());
            stmt.setDouble(3, transazione.getImporto());
            stmt.setTimestamp(4, new Timestamp(transazione.getDataOraPagamento().getTime()));
            stmt.setString(5, transazione.getMetodo());
            stmt.executeUpdate();
        }
    }
}
