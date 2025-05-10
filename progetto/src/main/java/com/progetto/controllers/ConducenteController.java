package com.progetto.controllers;

import com.progetto.DAO.ConducenteDao;
import com.progetto.models.Conducente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conducenti")
public class ConducenteController {

    @Autowired
    private ConducenteDao conducenteDao;

    @GetMapping("/tutti")
    public List<Conducente> getTuttiIConducenti() {
        return conducenteDao.trovaTutti();
    }
}
