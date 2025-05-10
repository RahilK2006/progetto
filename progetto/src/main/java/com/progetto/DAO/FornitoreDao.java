package com.progetto.DAO;

import com.progetto.models.Fornitore;
import java.sql.*;
import java.util.*;
import org.springframework.stereotype.Component;

@Component
public class FornitoreDao {

    private final Connection connection;

    public FornitoreDao(Connection connection) {
        this.connection = connection;
    }

    public List<Fornitore> trovaTutti() {
        List<Fornitore> fornitori = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM fornitore");
            while (rs.next()) {
                fornitori.add(new Fornitore(rs.getInt("id"), rs.getString("nome")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return fornitori;
    }
}
