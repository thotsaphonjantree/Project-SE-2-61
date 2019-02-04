package com.se.team21.backend.B5909711.Controller;
import com.se.team21.backend.B5909711.Entity.*;
import com.se.team21.backend.B5909711.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.repository.SportsEventRepository;
import com.se.team21.backend.b5910311.repository.SportsTypeRepository;
import com.se.team21.backend.b5910311.entity.SportsType;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ResultController {
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private SportsEventRepository sportsEventRepository;
    @Autowired
    private SportsTypeRepository sportsTypeRepository;
    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    public ResultController(ProvinceRepository provinceRepository,
                            SportsTypeRepository sportsTypeRepository,
                            SportsEventRepository sportsEventRepository,
                            ResultRepository resultRepository){
        this.provinceRepository = provinceRepository;
        this.sportsEventRepository = sportsEventRepository;
        this.sportsTypeRepository = sportsTypeRepository;
        this.resultRepository = resultRepository;
    }

    @GetMapping("/Result")
    public Collection<ResultEntity> Result(){
        return resultRepository.findAll().stream().collect(Collectors.toList());
    }
}
