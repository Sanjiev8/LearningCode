package org.example.controller;

import org.example.repository.CountryRepository;
import org.example.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping("/getAllCountries")
    public ResponseEntity<?> getAllCountries() {
        return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/addCountries")
    public ResponseEntity<?> addCountries(@RequestBody Country country) {
        return new ResponseEntity<>(countryRepository.save(country), HttpStatus.OK);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateCountries(@PathVariable("id") Long id, @RequestBody Country updateCountry) {
        Country existingCountry = countryRepository.findById(id).orElse(null);
        if(existingCountry == null){
            return new ResponseEntity<>("No such country exists.",HttpStatus.NOT_FOUND);
        }
        updateCountry.setId(existingCountry.getId());
        return new ResponseEntity<>(countryRepository.save(updateCountry), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCountry")
    public ResponseEntity<?> deleteCountry(
            @RequestParam Long id
    ) {
        Country existingCountry = countryRepository.findById(id).orElse(null);
        if(existingCountry == null){
            return new ResponseEntity<>("No such country exists.",HttpStatus.NOT_FOUND);
        }
        countryRepository.deleteById(id);
        return new ResponseEntity<>(id+" deleted successfully...", HttpStatus.OK);
    }
}
