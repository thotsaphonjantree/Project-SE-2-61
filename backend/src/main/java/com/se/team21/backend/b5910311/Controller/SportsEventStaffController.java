package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.SportsEventStaff;
import com.se.team21.backend.b5910311.repository.SportsEventStaffRepository;
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
public class SportsEventStaffController {
    @Autowired
    private SportsEventStaffRepository sportseventstaffRepository;
    
    @GetMapping("/staffname")
    public List<SportsEventStaff> showAllSportsEventStaff() {
        return sportseventstaffRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/staffname/{sesid}")
    public Optional<SportsEventStaff> showSportsEventStaffById(@PathVariable Long sesid) {
        return sportseventstaffRepository.findById(sesid);
    }

    @PostMapping("/staffname/{sesname}")
    public SportsEventStaff createSportsEventStaff(@PathVariable String sesname){
        SportsEventStaff sportseventstaff = new SportsEventStaff();
        sportseventstaff.setSesName(sesname);
        return sportseventstaffRepository.save(sportseventstaff);
    }

}