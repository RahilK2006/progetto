package com.progetto.DAO;

import com.progetto.models.Camion;
import java.sql.*;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class CamionDao {

    private final Connection connection;

    public CamionDao(Connection connection) {
        this.connection = connection;
    }

    public List<Camion> trovaTutti() {
        List<Camion> camion = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM camion");
            while (rs.next()) {
                camion.add(new Camion(rs.getString("targa")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return camion;
    }
}
