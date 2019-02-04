package com.se.team21.backend.B5909711.Controller;

import com.se.team21.backend.B5909711.Entity.*;
import com.se.team21.backend.B5909711.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class RatingController {
    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    public RatingController(RatingRepository ratingRepository){
        this.ratingRepository = ratingRepository;
    }

    @GetMapping("/Rating")
    public Collection<RatingEntity> RatingName(){
        return ratingRepository.findAll().stream().collect(Collectors.toList());
    }
}
