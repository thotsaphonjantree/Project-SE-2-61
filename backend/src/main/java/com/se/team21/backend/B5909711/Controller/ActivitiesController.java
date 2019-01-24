package com.se.team21.backend.B5909711.Controller;

import com.se.team21.backend.B5909711.Entity.ActivitiesEntity;
import com.se.team21.backend.B5909711.Repository.ActivitiesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ActivitiesController {
    @Autowired
    private ActivitiesRepository activitiesRepository;

    @Autowired
    public ActivitiesController(ActivitiesRepository activitiesRepository){
        this.activitiesRepository = activitiesRepository;
    }

    @GetMapping("/Activities")
    public Collection<ActivitiesEntity> getActivitiesName(){
        return activitiesRepository.findAll().stream().collect(Collectors.toList());
    }
}
