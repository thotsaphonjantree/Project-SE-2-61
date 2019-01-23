package com.se.team21.backend.AnanB5911417.Controller;

import com.se.team21.backend.AnanB5911417.Entity.*;
import com.se.team21.backend.AnanB5911417.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlaceEventController {

    @Autowired
    PlaceEventRepository placeEventRepository;
    @Autowired
    SportEventRepository sportEventRepository;
    @Autowired
    StaffRepository staffRepository;

    @GetMapping("/placeevent")
    public List<PlaceEvent> showAllPlaceEvent(){
        return placeEventRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/sportevent")
    public List<SportEvent> showAllSportEvent(){
        return sportEventRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/showstaff")
    public List<Staff> showAllStaff(){
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }

}
