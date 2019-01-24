package com.se.team21.backend.B5909711.Controller;

import com.se.team21.backend.B5909711.Entity.CountryEntity;
import com.se.team21.backend.B5909711.Repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    public CountryController(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @GetMapping("/Country")
    public Collection<CountryEntity> getCountryName(){
        return countryRepository.findAll().stream().collect(Collectors.toList());
    }
}
