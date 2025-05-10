package com.progetto.DAO;

import com.progetto.models.Nave;
import java.sql.*;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class NaveDao {

    private final Connection connection;

    public NaveDao(Connection connection) {
        this.connection = connection;
    }

    public List<Nave> trovaTutti() {
        List<Nave> lista = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM nave");
            while (rs.next()) {
                lista.add(new Nave(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
