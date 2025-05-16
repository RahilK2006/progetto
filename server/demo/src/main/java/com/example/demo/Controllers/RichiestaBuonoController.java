package com.example.demo.Controllers;

import com.example.demo.DAO.BuonoDiConsegnaDao;
import com.example.demo.DAO.RichiestaBuonoDao;
import com.example.demo.Model.RichiestaBuono;
import com.example.demo.Model.BuonoDiConsegna;

import com.example.demo.Model.PolizzaCarico;
import com.example.demo.DAO.PolizzaCaricoDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/richiestaBuono")
public class RichiestaBuonoController {

    @Autowired
    private RichiestaBuonoDao richiestaBuonoDao;

    @Autowired
    private BuonoDiConsegnaDao buonoDiConsegnaDAO;

        @Autowired
    private PolizzaCaricoDao polizzaDao;

    @GetMapping("/getAll")
    public List<RichiestaBuono> getAll() {
        return richiestaBuonoDao.getAll();
    }

    @GetMapping("/getByCliente")
    public List<RichiestaBuono> getByCliente(@RequestParam int idCliente) {
        return richiestaBuonoDao.getByCliente(idCliente);
    }

    @GetMapping("/getByPolizza")
    public List<RichiestaBuono> getByPolizza(@RequestParam int idPolizza) {
        return richiestaBuonoDao.getByPolizza(idPolizza);
    }

    @PostMapping("/add")
    public RichiestaBuono inserisci(@RequestBody RichiestaBuono rb) {
        boolean ok = richiestaBuonoDao.inserisci(rb);
        if (!ok) {
            throw new RuntimeException("Errore durante l'inserimento della richiesta");
        }
        return rb;
    }



    @PostMapping("/rifiuta")
    public String rifiutaRichiesta(@RequestParam int idRichiesta) {
        boolean ok = richiestaBuonoDao.aggiornaStato(idRichiesta, "rifiutata");
        if (!ok) throw new RuntimeException("Errore nel rifiuto della richiesta");
        return "Richiesta rifiutata correttamente";
    }

    @PostMapping("/accetta")
    public String accettaRichiesta(@RequestBody RichiestaBuono rb) {
        boolean aggiornato = richiestaBuonoDao.aggiornaStato(rb.getId(), "approvata");
        if (!aggiornato) throw new RuntimeException("Errore aggiornando la richiesta");

        // Crea buono
        try {
            buonoDiConsegnaDAO.creaBuono(rb.getId_polizza(), rb.getId_cliente(), rb.getPeso_richiesto());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Errore creando il buono");
        }

        return "Richiesta accettata e buono creato";
    }


    
        @PostMapping("/aggiornaStato")
        public String aggiornaStato(@RequestParam int id, @RequestParam String stato) {
            boolean ok = richiestaBuonoDao.aggiornaStato(id, stato);
            if (!ok) throw new RuntimeException("Errore aggiornando lo stato");
            return "Stato aggiornato a " + stato;
        }
    @GetMapping("/polizzeDisponibili")
    public List<PolizzaCarico> getPolizzeDisponibili(@RequestParam int idCliente) {
        // 1) Recupera tutte le polizze di questo cliente
        List<PolizzaCarico> polizzeCliente = polizzaDao.trovaPerCliente(idCliente);

        // 2) Per ogni polizza calcola il peso già richiesto e approvato
        List<RichiestaBuono> richiesteCliente = richiestaBuonoDao.getByCliente(idCliente);

        List<PolizzaCarico> polizzeDisponibili = new ArrayList<>();

        for (PolizzaCarico p : polizzeCliente) {
            double pesoTotalePolizza = p.getPeso_totale();

            // somma dei pesi richiesti per questa polizza con stato 'in attesa' o 'approvata'
            double pesoRichiestoTotale = richiesteCliente.stream()
                    .filter(r -> r.getId_polizza() == p.getId() && 
                                 (r.getStato().equals("in attesa") || r.getStato().equals("approvata")))
                    .mapToDouble(RichiestaBuono::getPeso_richiesto)
                    .sum();

            if (pesoRichiestoTotale < pesoTotalePolizza) {
                polizzeDisponibili.add(p);
            }
        }
        return polizzeDisponibili;  // <--- questa era la riga mancante

    }   
}


