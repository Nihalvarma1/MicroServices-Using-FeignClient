package com.ust.user_service.controller;

import com.ust.user_service.client.UserResponse;
import com.ust.user_service.dto.Userdto;
import com.ust.user_service.model.User;
import com.ust.user_service.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody @Valid Userdto user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("getpostbyuser/{userid}")
    public UserResponse getByUserid(@PathVariable("userid") Long userid){
        return userService.getByUserid(userid);
    }
}
