package com.example.demo.Controllers;

import com.example.demo.DAO.NaveDao;
import com.example.demo.Model.Nave;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nave")
public class NaveController {

    @Autowired
    private NaveDao naveDao;

    @GetMapping("/getAll")
    public List<Nave> getAllNavi() {
        return naveDao.trovaTutte();
    }

    @GetMapping("/getById")
    public Nave getNaveById(@RequestParam int id) {
        Nave nave = naveDao.trovaPerId(id);
        if (nave != null) {
            return nave;
        } else {
            throw new RuntimeException("Nave non trovata con id: " + id);
        }
    }

    @PostMapping("/add")
    public Nave aggiungiNave(@RequestBody Nave nave) {
        boolean risultato = naveDao.inserisci(nave);
        if (!risultato) {
            throw new RuntimeException("Errore durante l'inserimento della nave");
        }
        return nave;
    }

    @PutMapping("/update")
    public Nave aggiornaNave(@RequestBody Nave nave) {
        boolean risultato = naveDao.aggiorna(nave);
        if (!risultato) {
            throw new RuntimeException("Errore durante l'aggiornamento della nave con id: " + nave.getId());
        }
        return nave;
    }

    @DeleteMapping("/delete")
    public String eliminaNave(@RequestParam int id) {
        boolean risultato = naveDao.elimina(id);
        if (!risultato) {
            throw new RuntimeException("Errore durante l'eliminazione della nave con id: " + id);
        }
        return "Nave con id " + id + " eliminata con successo.";
    }
}
