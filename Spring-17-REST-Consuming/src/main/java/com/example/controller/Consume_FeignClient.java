package com.example.controller;


import com.example.client.UserClient;
import com.example.dto.ResponseWrapper;
import com.example.dto.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;

    public Consume_FeignClient(UserClient userClient) {
        this.userClient = userClient;
    }

    @GetMapping("/api/v2/users")
    public ResponseEntity<ResponseWrapper> getAllUsers(){
        return ResponseEntity.ok(new ResponseWrapper("Users are retrieved",userClient.getUsers()));
    }
}
