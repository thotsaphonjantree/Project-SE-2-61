package com.se.team21.backend.B5926329.Sprint2.Controller;

import com.se.team21.backend.B5926329.Sprint2.Entity.GenderJoin;
import com.se.team21.backend.B5926329.Sprint2.Repository.GenderJoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GenderJoinController {

    @Autowired
    GenderJoinRepository genderJoinRepository;

    @GetMapping("/genderjoins")
    public List<GenderJoin> showAllExpertLevel() {
        return genderJoinRepository.findAll().stream().collect(Collectors.toList());
    }

}
