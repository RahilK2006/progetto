package com.progetto.controllers;

import com.progetto.DAO.CamionDao;
import com.progetto.models.Camion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camion")
public class CamionController {

    @Autowired
    private CamionDao camionDao;

    @GetMapping("/tutti")
    public List<Camion> getTuttiICamion() {
        return camionDao.trovaTutti();
    }
}
