package it.utente.Ai_Pitittu.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.utente.Ai_Pitittu.Model.User;
import it.utente.Ai_Pitittu.Repository.UserRepository;
import jakarta.transaction.Transactional;


@Service
public class UserService {
	@Autowired
    private UserRepository repository;

    
public List<User> getAllUsers() {
    return repository.findAll();
}


public User getUserById(long id) {
    return repository.findById(id).orElse(null);
}

public User upsertUsers(User utente) {
    Optional<User> existingUsers = repository.findById(utente.getId());

    if (existingUsers.isPresent()) {
        // Aggiorna il prodotto esistente
    	User updateUtente = existingUsers.get();
        updateUtente.setUsername(utente.getUsername());
        updateUtente.setPassword(utente.getPassword());
        updateUtente.setEmail(utente.getEmail());
        updateUtente.setFirstname(utente.getFirstname());
        updateUtente.setLastname(utente.getLastname());
        updateUtente.setPhonenumber(utente.getPhonenumber());

//        if (!utente.getPassword().equals(updateUtente.getPassword())) {
//            updateUtente.setPassword(passwordEncoder.encode(utente.getPassword()));
//        }
        return repository.save(updateUtente);
    } else {
//        utente.setPassword(passwordEncoder.encode(utente.getPassword()));
        return repository.save(utente);
    }
}
public void deleteUsers(long id) {
	repository.deleteById(id);
}

@Transactional
public User registerUser(User user) throws RuntimeException {
    // Controlla se l'utente esiste già
    if (repository.existsByUsername(user.getUsername())) {
        throw new IllegalArgumentException("Username already exists");
    }
    // Controlla se il ruolo esiste
    
    
//    Role role = rolerepository.findByName("admin")
//                              .orElseThrow(() -> new RuntimeException("Default role not found"));
//    // Crea un nuovo utente
//     user = new User();
//    user.setUsername(user.getUsername());
//    user.setPassword(user.getPassword()); // Codifica la password
//    user.setEmail(user.getEmail());
//    user.setFirstname(user.getFirstname());
//    user.setLastname(user.getLastname());
//    user.setPhonenumber(user.getPhonenumber());


    // Salva l'utente nel database
    return repository.save(user);
}
}
