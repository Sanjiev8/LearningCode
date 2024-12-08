package org.example.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return new ResponseEntity<>("Hi, Welcome to Spring Rest APIs", HttpStatus.OK);
    }
    @PostMapping("/hi")
    public ResponseEntity<String> hi(@RequestBody String hi) {
        return new ResponseEntity<>("Hi how are you?"+hi, HttpStatus.OK);
    }
    @PostMapping("/hi2/{id}")
    public ResponseEntity<String> hi2(@PathVariable String id) {
        return new ResponseEntity<>("Hi how are you? "+id, HttpStatus.OK);
    }
    @PutMapping("/san")
    public ResponseEntity<?> san(@RequestBody String san) {
        return new ResponseEntity<>("hello "+san, HttpStatus.OK);
    }
    @PutMapping("/san2")
    public ResponseEntity<?> san2() {
        return new ResponseEntity<>("hello ", HttpStatus.OK);
    }
    @PostMapping("/books")
    public ResponseEntity<?> Book(
            @RequestParam String books,
            @RequestParam int pages
    ) {
        return new ResponseEntity<>("I have a "+books+"book :"+pages, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> Book(
            @RequestParam int id
    ) {
        return new ResponseEntity<>(id+" deleted successfully...", HttpStatus.OK);
    }

}
