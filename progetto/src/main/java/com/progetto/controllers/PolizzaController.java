package com.progetto.controllers;

import com.progetto.DAO.PolizzaDao;
import com.progetto.models.PolizzaCarico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/polizze")
public class PolizzaController {

    private final PolizzaDao polizzaDao;

    @Autowired
    public PolizzaController(PolizzaDao polizzaDao) {
        this.polizzaDao = polizzaDao;
    }

    @PostMapping
    public String createPolizza(@RequestBody PolizzaCarico polizza) {
        try {
            polizzaDao.insertPolizza(polizza);
            return "Polizza inserita con successo";
        } catch (SQLException e) {
            return "Errore nell'inserimento della polizza: " + e.getMessage();
        }
    }

    @GetMapping("/{id}")
    public PolizzaCarico getPolizzaById(@PathVariable int id) {
        try {
            return polizzaDao.getById(id);
        } catch (SQLException e) {
            return null; // In un'applicazione reale, gestiresti l'errore con un messaggio più esplicito
        }
    }
}
