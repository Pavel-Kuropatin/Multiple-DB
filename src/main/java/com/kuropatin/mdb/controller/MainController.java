package com.kuropatin.mdb.controller;

import com.kuropatin.mdb.model.first.User;
import com.kuropatin.mdb.model.second.Product;
import com.kuropatin.mdb.repository.first.UserRepository;
import com.kuropatin.mdb.repository.second.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @GetMapping
    public ResponseEntity<String> hello() {
        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }

    @GetMapping("/users")
    public ResponseEntity<Iterable<User>> getUsers() {
        return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> getProducts() {
        return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
    }
}