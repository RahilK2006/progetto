package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.DAO.ConducenteDao;
import com.example.demo.Model.Conducente;

import java.util.List;

@RestController
@RequestMapping("/conducente")
public class ConducenteController {

    @Autowired
    private ConducenteDao conducenteDao;   // Uso del ConducenteDao per l'accesso al DB

    // Restituisce tutti i conducenti
    @GetMapping("/getAll")
    public List<Conducente> getAllConducenti() {
        return conducenteDao.trovaTutti();
    }

    // Restituisce un conducente per ID
    @GetMapping("/getById")
    public Conducente getConducenteById(@RequestParam int id) {
        Conducente conducente = conducenteDao.trovaPerId(id);
        if (conducente != null) {
            return conducente;
        } else {
            throw new RuntimeException("Conducente non trovato con id: " + id);
        }
    }

    // Login per il conducente
    @CrossOrigin(origins = "*")
    @GetMapping("/login")
    public Conducente login(@RequestParam String username, @RequestParam String password) {
        Conducente conducente = conducenteDao.login(username, password);
        if (conducente != null) {
            return conducente;
        } else {
            throw new RuntimeException("Login fallito: credenziali non valide.");
        }
    }
}
