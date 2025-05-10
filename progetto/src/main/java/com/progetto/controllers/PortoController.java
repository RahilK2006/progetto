package com.progetto.controllers;

import com.progetto.DAO.PortoDao;
import com.progetto.models.Porto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/porti")
public class PortoController {

    private final PortoDao portoDao;

    @Autowired
    public PortoController(PortoDao portoDao) {
        this.portoDao = portoDao;
    }

    @GetMapping("/{id}")
    public Porto getPortoById(@PathVariable int id) {
        try {
            Porto porto = portoDao.getById(id);
            if (porto != null) {
                return porto;
            } else {
                throw new RuntimeException("Porto non trovato per l'id: " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Errore durante il recupero del porto con id: " + id);
        }
    }
}
