package com.progetto.controllers;

import com.progetto.DAO.TransazioneDao;
import com.progetto.models.Transazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@RestController
@RequestMapping("/transazioni")
public class TransazioneController {

    private final TransazioneDao transazioneDao;

    @Autowired
    public TransazioneController(TransazioneDao transazioneDao) {
        this.transazioneDao = transazioneDao;
    }

    @PostMapping
    public String inserisciTransazione(@RequestBody Transazione transazione) {
        try {
            transazioneDao.insertTransazione(transazione);
            return "Transazione inserita con successo!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Errore durante l'inserimento della transazione!";
        }
    }
}
