package com.example.SpringLab4.controllers;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.example.SpringLab4.model.Person;
import com.example.SpringLab4.model.util.Validator;
import com.example.SpringLab4.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/start")

@CrossOrigin
public class UserController {
    private final UserRepository userRepository;
    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping("/new")
    public ResponseEntity<String> addNewUser(@RequestBody Person person) {
        String resp = Validator.validateUser(person);
        if (!resp.equals("success")) return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        if (userRepository.findByUsername(person.getUsername()).stream().findAny().isPresent()) {
            resp = "Username is taken please choose another one";
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
        person.setPassword(BCrypt.withDefaults().hashToString(12, person.getPassword().toCharArray()));
        userRepository.save(person);
        person.setLogin(true);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    @PostMapping("/login")
    public ResponseEntity<String> authorizeUser(@RequestBody Person person) {
        System.out.println(person);
        String resp = Validator.validateUser(person);
        if (!resp.equals("success")) return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        if (userRepository.findByUsername(person.getUsername()).stream().findAny().isEmpty() ||
                !(BCrypt.verifyer().verify(person.getPassword().toCharArray(),
                        userRepository.findByUsername(person.getUsername()).get(0).getPassword()).verified)) {
            resp = "Invalid username or password";
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByUsername(person.getUsername()).get(0).getLogin()) {
            resp = "User in system";
            return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);

        }
        person.setLogin(true);
        person.setPassword(BCrypt.withDefaults().hashToString(12, person.getPassword().toCharArray()));
        userRepository.deleteByUsername(person.getUsername());
        userRepository.save(person);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/logout")
    public void logoutUser(@RequestBody Person person) {
        person.setPassword(BCrypt.withDefaults().hashToString(12, person.getPassword().toCharArray()));
        person.setLogin(false);
        System.out.println(person);
        userRepository.deleteByUsername(person.getUsername());
        userRepository.save(person);
    }

}
