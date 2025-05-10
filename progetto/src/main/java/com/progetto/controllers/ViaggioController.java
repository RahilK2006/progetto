package com.progetto.controllers;

import com.progetto.DAO.ViaggioDao;
import com.progetto.models.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/viaggi")
public class ViaggioController {

    private final ViaggioDao viaggioDao;

    @Autowired
    public ViaggioController(ViaggioDao viaggioDao) {
        this.viaggioDao = viaggioDao;
    }

    @GetMapping("/{id}")
    public Viaggio getViaggioById(@PathVariable int id) {
        try {
            return viaggioDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
