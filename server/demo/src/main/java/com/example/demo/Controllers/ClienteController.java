package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.DAO.ClienteDao;
import com.example.demo.Model.Cliente;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteDao clienteDao;  


    @GetMapping("/getAll")
    public List<Cliente> getAllUsers() {
        return clienteDao.trovaTutti();
    }

    @GetMapping("/getById")
    public Cliente getClienteById(@RequestParam int id) {
        Cliente cliente = clienteDao.trovaPerId(id);
        if (cliente != null) {
            return cliente;
        } else {
            throw new RuntimeException("Cliente non trovato con id: " + id);
        }
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/login")
    public Cliente login(@RequestParam String username, @RequestParam String password) {
        Cliente cliente = clienteDao.login(username, password);
        if (cliente != null) {
            return cliente;
        } else {
            throw new RuntimeException("Login fallito: credenziali non valide.");
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public Cliente registrazione(@RequestBody Cliente cliente) {
        boolean risultato = clienteDao.inserisci(cliente);
        if (!risultato) {
            throw new RuntimeException("Errore durante la registrazione");
        }
        return cliente;
    }
}
