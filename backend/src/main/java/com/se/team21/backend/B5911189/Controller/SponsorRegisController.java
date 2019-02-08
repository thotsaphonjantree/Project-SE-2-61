package com.se.team21.backend.B5911189.Controller;
import com.se.team21.backend.B5911189.Repository.*;
import com.se.team21.backend.B5911189.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class SponsorRegisController {
    @Autowired  private SponsorRegisRepository sponsorRegisRepository;
    @Autowired  private SponsorStatusRepository sponsorStatusRepository;
    @Autowired  private TransferRepository transferRepository;

    @Autowired SponsorRegisController (SponsorRegisRepository sponsorregisrepo){
        this.sponsorRegisRepository = sponsorregisrepo;
    }
    @GetMapping(path="/SponsorRegis",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SponsorRegis> SponsorRegis(){
        return sponsorRegisRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/SponsorRegis/{nameSponsorRegis}/{nameStatus}/{nameTransfer}/{Amount}")
    public SponsorRegis sponsorregis(  @PathVariable String nameSponsorRegis, @PathVariable String nameStatus,
                                       @PathVariable String nameTransfer,
                                       @PathVariable String Amount){

        SponsorRegis s = new SponsorRegis();

        Transfer t = transferRepository.findBynameTransfer(nameTransfer);
        System.out.println(nameTransfer);

        SponsorStatus ss = sponsorStatusRepository.findBynameStatus(nameStatus);
        System.out.println(nameStatus);



        s.setNameSponsorRegis(nameSponsorRegis);
        s.setTransfer(t);
        s.setSponsorStatus(ss);
        s.setAmount(Amount);

        return sponsorRegisRepository.save(s);


    }

}