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
    private RatingRepository ratingRepository;
    @Autowired
    private PersonTypeRepository personTypeRepository;

    @Autowired
    public ResultController(ProvinceRepository provinceRepository,
                            SportsTypeRepository sportsTypeRepository,
                            SportsEventRepository sportsEventRepository,
                            ResultRepository resultRepository,RatingRepository ratingRepository,
                            PersonTypeRepository personTypeRepository){
        this.provinceRepository = provinceRepository;
        this.sportsEventRepository = sportsEventRepository;
        this.sportsTypeRepository = sportsTypeRepository;
        this.resultRepository = resultRepository;
        this.ratingRepository = ratingRepository;
        this.personTypeRepository = personTypeRepository;
    }

    @GetMapping("/Result")
    public Collection<ResultEntity> Result(){
        return resultRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/Result/{activities}/{sportsType}/{inputName}/{rating}/{personType}/{inputDate}/{inputAddress}/{provin}")
    public ResultEntity resultEntity(@PathVariable String activities,
                                            @PathVariable String sportsType, @PathVariable String inputName,
                                            @PathVariable String rating, @PathVariable Date inputDate,
                                            @PathVariable String personType, @PathVariable String inputAddress,
                                            @PathVariable String provin) {
        ResultEntity re = new ResultEntity();
        SportsEvent se = sportsEventRepository.findByEventname(activities);
        SportsType st = sportsTypeRepository.findBySportname(sportsType);
        RatingEntity ratingEntity = ratingRepository.findByratingName(rating);
        PersonTypeEntity pte = personTypeRepository.findBypersonTypeName(personType);
        ProvinceEntity pe = provinceRepository.findByprovinceName(provin);

        re.setPersonTypeEntity(pte);
        re.setRatingEntity(ratingEntity);
        re.setProvinceEntity(pe);
        re.setSportsType(st);
        re.setSportsEvent(se);
        re.setResultDate(inputDate);
        re.setResultAddress(inputAddress);
        re.setResultName(inputName);

        return resultRepository.save(re);
    }
}
