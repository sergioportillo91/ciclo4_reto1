package com.ciclo4_reto1.ciclo_4_reto_1.service;

import com.ciclo4_reto1.ciclo_4_reto_1.model.User;
import com.ciclo4_reto1.ciclo_4_reto_1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }
    public Optional<User> getUser(int id){
        return userRepository.getUser(id);

    }
    public User registrar(User user){
        if(user.getId()==null){
            if(existeEmail(user.getEmail())==false) {
                return userRepository.save(user);
            }else {
                return user;
            }
        } else {
            return user;
        }
    }
    public Boolean existeEmail(String email) {
        return userRepository.existeEmail(email);
    }
    public User autenticarUsuario(String email,String password){
        Optional<User> usuario = userRepository.autenticaUsuario(email,password);

        if(usuario.isEmpty()){
            return new User(email,password,"NO DEFINIDO");
        } else {
            return usuario.get();
        }
    }
}
