package com.ciclo4_reto1.ciclo_4_reto_1.controller;

import com.ciclo4_reto1.ciclo_4_reto_1.model.User;
import com.ciclo4_reto1.ciclo_4_reto_1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return  userService.registrar(user);
    }

    @GetMapping("/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return userService.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticar(@PathVariable("email") String email,@PathVariable("password") String password){
        return userService.autenticarUsuario(email,password);
    }


}
