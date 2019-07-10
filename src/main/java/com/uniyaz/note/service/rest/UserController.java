package com.uniyaz.note.service.rest;

import com.uniyaz.note.domain.User;
import com.uniyaz.note.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gökçe DOĞANAY
 * @since 0.0.1
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user")
    public User saveKullanici(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("/user")
    public List<User> findAllKullanicilar(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public User findKullaniciById(@PathVariable Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("Kullanıcı Bulunamadı.")); }

    @DeleteMapping("/user/{id}")
    public void deleteKullanici(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
