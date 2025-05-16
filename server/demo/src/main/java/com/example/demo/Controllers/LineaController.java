package com.example.demo.Controllers;

import com.example.demo.DAO.LineaDao;
import com.example.demo.Model.Linea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/linea")
@CrossOrigin(origins = "*")
public class LineaController {

    @Autowired
    private LineaDao lineaDao;

    @GetMapping("/getAll")
    public List<Linea> getAllLinee() {
        return lineaDao.trovaTutti();
    }

    @GetMapping("/getById")
    public Linea getLineaById(@RequestParam int id) {
        Linea linea = lineaDao.trovaPerId(id);
        if (linea != null) return linea;
        throw new RuntimeException("Linea non trovata con ID: " + id);
    }

    @PostMapping("/add")
    public Linea aggiungiLinea(@RequestBody Linea linea) {
        boolean success = lineaDao.inserisci(linea);
        if (!success) throw new RuntimeException("Errore inserimento linea");
        return linea;
    }

    @PutMapping("/update")
    public Linea aggiornaLinea(@RequestBody Linea linea) {
        boolean success = lineaDao.aggiorna(linea);
        if (!success) throw new RuntimeException("Errore aggiornamento linea con ID: " + linea.getId());
        return linea;
    }

    @DeleteMapping("/delete")
    public String eliminaLinea(@RequestParam int id) {
        boolean success = lineaDao.elimina(id);
        if (!success) throw new RuntimeException("Errore eliminazione linea con ID: " + id);
        return "Linea con ID " + id + " eliminata.";
    }
}
