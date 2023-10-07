package com.service.zoo.api.controller;

import com.service.zoo.api.model.User;
import com.service.zoo.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity registration(@RequestBody User user){
        try {
            userRepository.save(user);
            return ResponseEntity.ok("Регистрация прошла успешно");
        }
        catch(Exception exception){
            return ResponseEntity.badRequest().body("биляяяя...Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getUsers(){
        try {
            return ResponseEntity.ok("Сервак батрачит...ПРАЗДНИК!!!!");
        }
        catch(Exception exception){
            return ResponseEntity.badRequest().body("биляяяя...Произошла ошибка");
        }
    }
}
