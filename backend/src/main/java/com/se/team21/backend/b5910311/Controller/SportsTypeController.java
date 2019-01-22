package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.SportsType;
import com.se.team21.backend.b5910311.repository.SportsTypeRepository;
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
public class SportsTypeController {
    @Autowired
    private SportsTypeRepository sportstypeRepository;

    @GetMapping("/sportstype")
    public List<SportsType> showAllSportsType() {
        return sportstypeRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/sportstype/{stid}")
    public Optional<SportsType> showSportsTypeById(@PathVariable Long stid) {
        return sportstypeRepository.findById(stid);
    }

    @PostMapping("/sportstype/create/{sportname}")
    public SportsType createSportsType(@PathVariable String sportname){
        SportsType sportstype = new SportsType();
        sportstype.setSportName(sportname);
        return sportstypeRepository.save(sportstype);
    }
}