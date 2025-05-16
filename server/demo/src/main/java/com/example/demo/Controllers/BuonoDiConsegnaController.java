package com.example.demo.Controllers;

import com.example.demo.DAO.BuonoDiConsegnaDao;
import com.example.demo.Model.BuonoDiConsegna;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buono")
public class BuonoDiConsegnaController {

    @Autowired
    private BuonoDiConsegnaDao buonoDao;

    // Ottiene tutti i buoni
    @GetMapping("/getAll")
    public List<BuonoDiConsegna> getAllBuoni() {
        return buonoDao.trovaTutti();
    }

    // Ottiene i buoni di un cliente specifico
    @GetMapping("/getByCliente")
    public List<BuonoDiConsegna> getBuoniPerCliente(@RequestParam int idCliente) {
        return buonoDao.trovaPerCliente(idCliente);
    }

    // Crea un nuovo buono (da usare quando si accetta una richiesta)
    @PostMapping("/crea")
    public String creaBuono(@RequestBody BuonoDiConsegna buono) {
        boolean success = buonoDao.creaBuono(
            buono.getId_polizza(),
            buono.getId_cliente(),
            buono.getPeso_riferito()
        );
        if (success) {
            return "Buono creato con successo.";
        } else {
            throw new RuntimeException("Errore durante la creazione del buono.");
        }
    }
}
