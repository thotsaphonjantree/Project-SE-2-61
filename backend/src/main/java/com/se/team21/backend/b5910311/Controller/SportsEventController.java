package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.repository.SportsEventRepository;
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
public class SportsEventController {
    @Autowired
    private SportsEventRepository sportseventRepository;

    @GetMapping("/event")
    public List<SportsEvent> showAllSportsType() {
        return sportseventRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/event/{seid}")
    public Optional<SportsEvent> showLocationById(@PathVariable Long seid) {
        return sportseventRepository.findById(seid);
    }

    @PostMapping("/event/create/{event}")
    public SportsEvent createSportsEvent(@PathVariable String eventname){
        SportsEvent sportsevent = new SportsEvent();
        sportsevent.setEventName(eventname);
        return sportseventRepository.save(sportsevent);
    }
}