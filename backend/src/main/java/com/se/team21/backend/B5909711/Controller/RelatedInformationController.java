package com.se.team21.backend.B5909711.Controller;

import com.se.team21.backend.B5909711.Entity.*;
import com.se.team21.backend.B5909711.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.repository.SportsEventRepository;

import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class RelatedInformationController {
    @Autowired
    private RelatedInformationRepository relatedInformationRepository;
    @Autowired
    private AgencyTypeRepository agencyTypeRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private ProvinceRepository provinceRepository;
    @Autowired
    private SportsEventRepository sportsEventRepository;

    @Autowired
    public RelatedInformationController(RelatedInformationRepository relatedInformationRepository, AgencyTypeRepository agencyTypeRepository
                                        , CountryRepository countryRepository
                                        , ProvinceRepository provinceRepository, SportsEventRepository sportsEventRepository){
        this.relatedInformationRepository = relatedInformationRepository;
        this.agencyTypeRepository = agencyTypeRepository;
        this.countryRepository = countryRepository;
        this.provinceRepository = provinceRepository;
        this.sportsEventRepository = sportsEventRepository;
    }

    @GetMapping("/RelatedInformation")
    public Collection<RelatedInformationEntity> RelatedInformation(){
        return relatedInformationRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/RelatedInformation/{agent}/{provin}/{country}/{Nameoforganization}/{Addressagency}/{inputdate}/{Inputdataphonenumber}/{Inputdatae_mail}/{activities}")
    public RelatedInformationEntity related(@PathVariable String agent,
                                            @PathVariable String provin, @PathVariable String country,
                                            @PathVariable String Nameoforganization, @PathVariable Date inputdate,
                                            @PathVariable String Addressagency, @PathVariable String Inputdataphonenumber,
                                            @PathVariable String Inputdatae_mail, @PathVariable String activities) {
        RelatedInformationEntity r = new RelatedInformationEntity();
        AgencyTypeEntity a = agencyTypeRepository.findByagencyName(agent);
        SportsEvent s = sportsEventRepository.findByEventname(activities);
        System.out.println(activities);
        System.out.println(agent);
        CountryEntity c = countryRepository.findBycountryName(country);
        System.out.println(country);
        ProvinceEntity p = provinceRepository.findByprovinceName(provin);
        System.out.println(provin);

        r.setAgencyTypeEntity(a);
        r.setCountryEntity(c);
        r.setSportsEvent(s);
        r.setRelatedinformationAddress(Addressagency);
        r.setRelatedinformationName(Nameoforganization);
        r.setRelatedinformationPhone(Inputdataphonenumber);
        r.setRelatedinformationEmail(Inputdatae_mail);
        r.setRelatedinformationDate(inputdate);
        r.setProvinceEntity(p);

        return relatedInformationRepository.save(r);
    }

    @PutMapping(path = "/updateRelatedInformation/{relatedinformationID}/{relatedinformationName}/{relatedinformationDate}/{relatedinformationAddress}/{relatedinformationPhone}/{relatedinformationEmail}/{agencyName}/{countryName}/{provinceName}/{activitiesName}")
    public RelatedInformationEntity editRelatedInformation(@RequestBody RelatedInformationEntity relatedInformation, @PathVariable Long relatedinformationID, @PathVariable String relatedinformationName, @PathVariable Date relatedinformationDate, @PathVariable String relatedinformationAddress, @PathVariable String relatedinformationPhone, @PathVariable String relatedinformationEmail, @PathVariable String agencyName, @PathVariable String countryName, @PathVariable String provinceName, @PathVariable String activitiesName){
        AgencyTypeEntity a = agencyTypeRepository.findByagencyName(agencyName);
        CountryEntity c = countryRepository.findBycountryName(countryName);
        ProvinceEntity p = provinceRepository.findByprovinceName(provinceName);
        SportsEvent s = sportsEventRepository.findByEventname(activitiesName);
//        ActivitiesEntity ac = activitiesRepository.findByactivitiesName(activitiesName);
        return relatedInformationRepository.findById(relatedinformationID).map(roomedit ->{
                    roomedit.setRelatedinformationID(relatedinformationID);
                    roomedit.setRelatedinformationName(relatedinformationName);
                    roomedit.setRelatedinformationAddress(relatedinformationAddress);
                    roomedit.setRelatedinformationPhone(relatedinformationPhone);
                    roomedit.setRelatedinformationEmail(relatedinformationEmail);
                    roomedit.setRelatedinformationDate(relatedinformationDate);
                    roomedit.setAgencyTypeEntity(a);
                    roomedit.setCountryEntity(c);
                    roomedit.setProvinceEntity(p);
                    roomedit.setSportsEvent(s);
//                    roomedit.setActivitieEntity(ac);

                    return relatedInformationRepository.save(roomedit);
                }
        ).orElseGet(() ->{
            return relatedInformationRepository.save(relatedInformation);
        });
    }
}
