package com.se.team21.backend.B5909711.Controller;

import com.se.team21.backend.B5909711.Entity.AgencyTypeEntity;
import com.se.team21.backend.B5909711.Repository.AgencyTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class AgencyTypeController {
    @Autowired
    private AgencyTypeRepository agencyTypeRepository;

    @Autowired
    public AgencyTypeController(AgencyTypeRepository agencyTypeRepository){
        this.agencyTypeRepository = agencyTypeRepository;
    }

    @GetMapping("/agencyType")
    public Collection<AgencyTypeEntity> getAgencyName(){
        return agencyTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/agencyType/{agencyTypeN}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AgencyTypeEntity getAgencyName(@PathVariable String agencyTypeN){
        AgencyTypeEntity AgencyType = new AgencyTypeEntity();
        AgencyType.setAgencyName(agencyTypeN);
        return agencyTypeRepository.save(AgencyType);
    }
}
