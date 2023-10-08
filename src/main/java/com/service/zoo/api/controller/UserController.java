package com.service.zoo.api.controller;

import com.service.zoo.api.exception.AuthorizationInvalidPasswordException;
import com.service.zoo.api.exception.UserAlreadyExistException;
import com.service.zoo.api.exception.UserNotFoundException;
import com.service.zoo.api.Entity.UserEntity;
import com.service.zoo.api.model.User;
import com.service.zoo.sevice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity registration(@RequestBody UserEntity userEntity) {
        try {
            userService.registration(userEntity);
            return ResponseEntity.ok("Регистрация прошла успешно");
        } catch (UserAlreadyExistException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneUser(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(userService.getUserById(id));
        } catch (UserNotFoundException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        try {
            return ResponseEntity.ok(userService.deleteUserById(id));
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping("/logg-in")
    public ResponseEntity authorization(@RequestBody User user){
        try {
            return ResponseEntity.ok(userService.atthorization(user));
        }
        catch (AuthorizationInvalidPasswordException exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

    @GetMapping
    public ResponseEntity getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
