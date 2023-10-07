package com.service.zoo.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

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
