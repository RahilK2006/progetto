package com.progetto.controllers;

import com.progetto.DAO.GuidaDao;
import com.progetto.models.Guida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/guide")
public class GuidaController {

    private final GuidaDao guidaDao;

    @Autowired
    public GuidaController(GuidaDao guidaDao) {
        this.guidaDao = guidaDao;
    }

    @PostMapping
    public String insertGuida(@RequestBody Guida guida) {
        try {
            guidaDao.insertGuida(guida);
            return "Guida inserita correttamente!";
        } catch (SQLException e) {
            return "Errore durante l'inserimento della guida: " + e.getMessage();
        }
    }
}
