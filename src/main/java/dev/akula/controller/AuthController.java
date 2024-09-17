package dev.akula.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/signin")
    public ResponseEntity<String> signin() {
        return ResponseEntity.ok("signin");
    }

    @PostMapping("/signup")
    public ResponseEntity<String> signup() {
        return ResponseEntity.ok("signup");
    }

}