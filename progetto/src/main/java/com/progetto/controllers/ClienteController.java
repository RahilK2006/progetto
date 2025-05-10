package com.progetto.controllers;

import com.progetto.DAO.ClienteDao;
import com.progetto.models.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
@RequestMapping("/clienti")
public class ClienteController {

    private final ClienteDao clienteDao;

    @Autowired
    public ClienteController(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }



    @GetMapping("/{email}")
    public Cliente getClienteByEmail(@PathVariable String email) {
        try {
            return clienteDao.getByEmail(email);  
        } catch (SQLException e) {
            e.printStackTrace();
            return null;  
        }
    }

    @PostMapping
    public void addCliente(@RequestBody Cliente cliente) {
        try {
            clienteDao.insertCliente(cliente);  
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody String body) {
        try {
            String[] params = body.split("&");
            String email = params[0].split("=")[1];
            String password = params[1].split("=")[1];

            boolean isAuthenticated = clienteDao.loginn(email, password);
            
            if (isAuthenticated) {
                return "Login effettuato con successo!";
            } else {
                return "Email o password errati.";
            }
        } catch (SQLException e) {
            return "Errore nel processo di login: " + e.getMessage();
        }
    }

}