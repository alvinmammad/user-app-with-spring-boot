package com.java.example.controller;

import com.java.example.exception.UserNotFoundException;
import com.java.example.model.User;
import com.java.example.service.RestAPIServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/rest/users/")

public class SpringMVCRestController {
    @Autowired
    private RestAPIServiceImpl restAPIService;

    //Get user by ID
    @GetMapping("user/{id}")

    public ResponseEntity getUser(@PathVariable("id") Long id) {
        try {
            User user = restAPIService.findUser(id);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Get users(users) by Name
    @GetMapping("user/byName/{name}")
    public ResponseEntity getUserByName(@PathVariable("name") String name) {
        try {
            List<User> userlist = restAPIService.findUserByFirstName(name);
            return ResponseEntity.ok(userlist);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    //Get user(users) by Birth date
    @GetMapping("user/byDate/{birthDate}")
    public ResponseEntity getUserByDate(@PathVariable("birthDate") String birthDate) throws Exception {
        try {
            System.out.println(birthDate);
            List<User> userlist = restAPIService.findUserByBirthday(birthDate);
            return ResponseEntity.ok(userlist);
            //
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
    //CRUD(Create)
    @PostMapping(value = "add", consumes = "application/json", produces = "application/json")
    public ResponseEntity createUser(@RequestBody User user) {
        try {
            restAPIService.createUser(user);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    //CRUD(Update/Edit)
    @PutMapping(value = "update/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity updateUser(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            restAPIService.updateUser(user, id);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //CRUD(Delete)
    @DeleteMapping(value = "delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Long id) {
        try {
            restAPIService.deleteUser(id);
            return ResponseEntity.ok(id);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
