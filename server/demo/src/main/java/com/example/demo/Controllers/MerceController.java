package com.example.demo.Controllers;

import com.example.demo.DAO.MerceDao;
import com.example.demo.Model.Merce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/merce")
@CrossOrigin(origins = "*")
public class MerceController {

    @Autowired
    private MerceDao merceDao;

    @GetMapping("/getByFornitore")
    public List<Merce> getMerciByFornitore(@RequestParam int idFornitore) {
        return merceDao.trovaPerFornitore(idFornitore);
    }

    @PostMapping("/add")
    public Merce aggiungiMerce(@RequestBody Merce merce) {
        boolean success = merceDao.inserisci(merce);
        if (!success) throw new RuntimeException("Errore inserimento merce");
        return merce;
    }

    @PutMapping("/update")
    public Merce aggiornaMerce(@RequestBody Merce merce) {
        boolean success = merceDao.aggiorna(merce);
        if (!success) throw new RuntimeException("Errore aggiornamento merce");
        return merce;
    }

    @DeleteMapping("/delete")
    public String eliminaMerce(@RequestParam int id, @RequestParam int idFornitore) {
        boolean success = merceDao.elimina(id, idFornitore);
        if (!success) throw new RuntimeException("Errore eliminazione merce");
        return "Merce con ID " + id + " eliminata.";
    }
}
