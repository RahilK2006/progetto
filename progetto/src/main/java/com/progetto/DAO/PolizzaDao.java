package com.progetto.DAO;


import com.progetto.models.PolizzaCarico;
import java.sql.*;

public class PolizzaDao {
    private final Connection connection;

    public PolizzaDao(Connection connection) {
        this.connection = connection;
    }

    public void insertPolizza(PolizzaCarico polizza) throws SQLException {
        String sql = "INSERT INTO polizza_carico (id_viaggio, id_fornitore, tipologia_merce, peso_totale, giorni_franchigia, tariffa_giornaliera) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, polizza.getIdViaggio());
            stmt.setInt(2, polizza.getIdFornitore());
            stmt.setString(3, polizza.getTipologiaMerce());
            stmt.setDouble(4, polizza.getPesoTotale());
            stmt.setDouble(5, polizza.getGiorniFranchigia());
            stmt.setDouble(6, polizza.getTariffaGiornaliera());
            stmt.executeUpdate();
        }
    }

    public PolizzaCarico getById(int id) throws SQLException {
        String sql = "SELECT * FROM polizza_carico WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new PolizzaCarico(
                    rs.getInt("id"),
                    rs.getInt("id_viaggio"),
                    rs.getInt("id_fornitore"),
                    rs.getString("tipologia_merce"),
                    rs.getDouble("peso_totale"),
                    rs.getDouble("giorni_franchigia"),
                    rs.getDouble("tariffa_giornaliera")
                );
            }
        }
        return null;
    }
}
