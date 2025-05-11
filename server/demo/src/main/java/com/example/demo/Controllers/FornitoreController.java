package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.DAO.FornitoreDao;
import com.example.demo.Model.Fornitore;

import java.util.List;

@RestController
@RequestMapping("/fornitore")
public class FornitoreController {

    @Autowired
    private FornitoreDao fornitoreDao;   // Uso del FornitoreDao per l'accesso al DB

    // Restituisce tutti i fornitori
    @GetMapping("/getAll")
    public List<Fornitore> getAllFornitori() {
        return fornitoreDao.trovaTutti();
    }

    // Restituisce un fornitore per ID
    @GetMapping("/getById")
    public Fornitore getFornitoreById(@RequestParam int id) {
        Fornitore fornitore = fornitoreDao.trovaPerId(id);
        if (fornitore != null) {
            return fornitore;
        } else {
            throw new RuntimeException("Fornitore non trovato con id: " + id);
        }
    }

    // Login per il fornitore
    @CrossOrigin(origins = "*")
    @GetMapping("/login")
    public Fornitore login(@RequestParam String username, @RequestParam String password) {
        Fornitore fornitore = fornitoreDao.login(username, password);
        if (fornitore != null) {
            return fornitore;
        } else {
            throw new RuntimeException("Login fallito: credenziali non valide.");
        }
    }
}
