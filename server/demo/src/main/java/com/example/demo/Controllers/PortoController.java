package com.example.demo.Controllers;

import com.example.demo.DAO.PortoDao;
import com.example.demo.Model.Porto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/porto")
public class PortoController {

    @Autowired
    private PortoDao portoDao;

    @GetMapping("/getAll")
    public List<Porto> getAllPorti() {
        return portoDao.trovaTutti();
    }

    @GetMapping("/getById")
    public Porto getPortoById(@RequestParam int id) {
        Porto porto = portoDao.trovaPerId(id);
        if (porto != null) return porto;
        throw new RuntimeException("Porto non trovato con ID: " + id);
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/add")
    public Porto aggiungiPorto(@RequestBody Porto porto) {
        boolean res = portoDao.inserisci(porto);
        if (!res) throw new RuntimeException("Errore inserimento porto");
        return porto;
    }

    @PutMapping("/update")
    public Porto aggiornaPorto(@RequestBody Porto porto) {
        boolean res = portoDao.aggiorna(porto);
        if (!res) throw new RuntimeException("Errore aggiornamento porto con ID: " + porto.getId());
        return porto;
    }

    @DeleteMapping("/delete")
    public String eliminaPorto(@RequestParam int id) {
        boolean res = portoDao.elimina(id);
        if (!res) throw new RuntimeException("Errore eliminazione porto con ID: " + id);
        return "Porto con ID " + id + " eliminato.";
    }
}
