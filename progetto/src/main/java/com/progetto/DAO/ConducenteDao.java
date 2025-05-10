package com.progetto.DAO;

import com.progetto.models.Conducente;
import java.sql.*;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class ConducenteDao {

    private final Connection connection;

    public ConducenteDao(Connection connection) {
        this.connection = connection;
    }

    public List<Conducente> trovaTutti() {
        List<Conducente> lista = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM conducente");
            while (rs.next()) {
                lista.add(new Conducente(rs.getInt("id"), rs.getString("nome"), rs.getString("cognome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
