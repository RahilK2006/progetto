package com.progetto.controllers;

import com.progetto.DAO.BuonoDiConsegnaDao;
import com.progetto.models.BuonoDiConsegna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
@RequestMapping("/buoni")
public class BuonoDiConsegnaController {

    private final BuonoDiConsegnaDao buonoDiConsegnaDao;

    @Autowired
    public BuonoDiConsegnaController(BuonoDiConsegnaDao buonoDiConsegnaDao) {
        this.buonoDiConsegnaDao = buonoDiConsegnaDao;
    }

    @PostMapping
    public void addBuono(@RequestBody BuonoDiConsegna buono) {
        try {
            buonoDiConsegnaDao.insertBuono(buono);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
