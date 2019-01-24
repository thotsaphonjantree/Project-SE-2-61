package com.se.team21.backend.B5909711.Controller;

import com.se.team21.backend.B5909711.Entity.ProvinceEntity;
import com.se.team21.backend.B5909711.Repository.ProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class ProvinceController {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Autowired
    public ProvinceController(ProvinceRepository provinceRepository){
        this.provinceRepository = provinceRepository;
    }

    @GetMapping("/Province")
    public Collection<ProvinceEntity> getProvinceName(){
        return provinceRepository.findAll().stream().collect(Collectors.toList());
    }
}
