package com.example.demo.Controllers;

import com.example.demo.DAO.PolizzaCaricoDao;
import com.example.demo.Model.PolizzaCarico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/polizza")
@CrossOrigin(origins = "*")
public class PolizzaCaricoController {

    @Autowired
    private PolizzaCaricoDao polizzaDao;

    @PostMapping("/add")
    public PolizzaCarico add(@RequestBody PolizzaCarico p) {
        boolean ok = polizzaDao.inserisci(p);
        if (!ok) throw new RuntimeException("Errore inserimento polizza");
        return p;
    }

    @GetMapping("/getByFornitore")
    public List<PolizzaCarico> getByFornitore(@RequestParam int idFornitore) {
        return polizzaDao.trovaPerFornitore(idFornitore);
    }

    @GetMapping("/getAll")
    public List<PolizzaCarico> getAll() {
        return polizzaDao.getAll();
    }
}
