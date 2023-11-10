package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;
import ru.kata.spring.boot_security.demo.util.UserValidator;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminRestController {
    private final UserService userService;


    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> showAllUser(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> showUserById(@PathVariable Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        userService.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        userService.update(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
}
