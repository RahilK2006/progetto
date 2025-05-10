package com.progetto.controllers;

import com.progetto.DAO.NaveDao;
import com.progetto.models.Nave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/navi")
public class NaveController {

    @Autowired
    private NaveDao naveDao;

    @GetMapping("/tutte")
    public List<Nave> getTutteLeNavi() {
        return naveDao.trovaTutti();
    }
}

