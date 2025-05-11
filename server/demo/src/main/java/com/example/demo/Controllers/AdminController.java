package com.example.demo.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.DAO.AdminDao;
import com.example.demo.Model.Admin;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminDao adminDao;   // Uso dell'AdminDao per l'accesso al DB

    // Restituisce tutti gli admin
    @GetMapping("/getAll")
    public List<Admin> getAllAdmins() {
        return adminDao.trovaTutti();
    }

    // Restituisce un admin per ID
    @GetMapping("/getById")
    public Admin getAdminById(@RequestParam int id) {
        Admin admin = adminDao.trovaPerId(id);
        if (admin != null) {
            return admin;
        } else {
            throw new RuntimeException("Admin non trovato con id: " + id);
        }
    }

    // Login per l'admin
    @CrossOrigin(origins = "*")
    @GetMapping("/login")
    public Admin login(@RequestParam String username, @RequestParam String password) {
        Admin admin = adminDao.login(username, password);
        if (admin != null) {
            return admin;
        } else {
            throw new RuntimeException("Login fallito: credenziali non valide.");
        }
    }
}
