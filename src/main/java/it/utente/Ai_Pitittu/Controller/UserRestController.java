package it.utente.Ai_Pitittu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.utente.Ai_Pitittu.Model.User;
import it.utente.Ai_Pitittu.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserRestController {
		
@Autowired
private UserService userservice;

@GetMapping
public List<User> getAllProducts() {
    return userservice.getAllUsers();
}

@GetMapping("/{id}")
public User getUtenteById(@PathVariable int id) {
    return userservice.getUserById(id);
}

@PostMapping
public User registerUser(@RequestBody User utente) {
    
	return userservice.registerUser(utente);
}
@PutMapping("/{id}")
public User upsertUser(@RequestBody User utente) {
    
	return userservice.upsertUsers(utente);
}

@DeleteMapping("/{id}")
public void deleteUtente(@PathVariable int id) {
	userservice.deleteUsers(id);
}
}
