package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.Location;
import com.se.team21.backend.b5910311.repository.LocationRepository;
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
public class LocationController {

    @Autowired
    private LocationRepository locationRepository;

    @GetMapping("/location")
    public List<Location> showAllLocation() {
        return locationRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/location/{lid}")
    public Optional<Location> showLocationById(@PathVariable Long lid) {
        return locationRepository.findById(lid);
    }

    @PostMapping("/location/create/{locations}")
    public Location createLocation(@PathVariable String locations){
        Location location = new Location();
        location.setLocations(locations);
        return locationRepository.save(location);
    }
}