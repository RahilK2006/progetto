package com.progetto.controllers;

import com.progetto.DAO.FornitoreDao;
import com.progetto.models.Fornitore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornitori")
public class FornitoreController {

    @Autowired
    private FornitoreDao fornitoreDao;

    @GetMapping("/tutti")
    public List<Fornitore> getTuttiIFornitori() {
        return fornitoreDao.trovaTutti();
    }
}
