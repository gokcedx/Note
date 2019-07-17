package com.uniyaz.note.service.rest;

import com.uniyaz.note.domain.User;
import com.uniyaz.note.dto.UserDto;
import com.uniyaz.note.repository.UserRepository;
import com.uniyaz.note.service.UserService;
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

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User saveKullanici(@RequestBody UserDto userDto){
        return userService.saveUser(userDto);
    }

    @GetMapping("/user")
    public List<User> findAllKullanicilar(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public UserDto findKullaniciById(@PathVariable Long id){
        return userService.findById(id);
    }

    @DeleteMapping("/user/{id}")
    public void deleteKullanici(@PathVariable Long id){
        userRepository.deleteById(id);
    }

}
