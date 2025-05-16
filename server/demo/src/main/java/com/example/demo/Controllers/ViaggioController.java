package com.example.demo.Controllers;

import com.example.demo.DAO.ViaggioDao;
import com.example.demo.Model.Viaggio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/viaggio")
@CrossOrigin(origins = "*")
public class ViaggioController {

    @Autowired
    private ViaggioDao viaggioDao;

    @GetMapping("/getAll")
    public List<Viaggio> getAll() {
        return viaggioDao.trovaTutti();
    }

    @PostMapping("/add")
    public Viaggio add(@RequestBody Viaggio viaggio) {
        boolean ok = viaggioDao.inserisci(viaggio);
        if (!ok) throw new RuntimeException("Errore inserimento viaggio");
        return viaggio;
    }


    @PutMapping("/update")
    public Viaggio aggiorna(@RequestBody Viaggio viaggio) {
        boolean ok = viaggioDao.aggiorna(viaggio);
        if (!ok) throw new RuntimeException("Errore aggiornamento viaggio ID: " + viaggio.getId());
        return viaggio;
    }

    @DeleteMapping("/delete")
    public String elimina(@RequestParam int id) {
        boolean ok = viaggioDao.elimina(id);
        if (!ok) throw new RuntimeException("Errore eliminazione viaggio ID: " + id);
        return "Viaggio eliminato con ID: " + id;
    }

}
