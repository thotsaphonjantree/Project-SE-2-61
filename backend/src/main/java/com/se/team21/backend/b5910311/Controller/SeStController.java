package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.SeSt;
import com.se.team21.backend.b5910311.repository.SeStRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SeStController {
    @Autowired
    private SeStRepository sestRepository;

    @GetMapping("/sest")
    public List<SeSt> showAllSportsType() {
        return sestRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/sest/{id}")
    public Optional<SeSt> showLocationById(@PathVariable Long id) {
        return sestRepository.findById(id);
    }

    @PostMapping("/sest/create/{sest}")
    public SeSt createSeSt(@PathVariable Long id){
        SeSt sest = new SeSt();
        sest.setId(id);
        return sestRepository.save(sest);
    }
}