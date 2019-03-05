package com.se.team21.backend.B5911189.Controller;
import com.se.team21.backend.B5911189.Repository.*;
import com.se.team21.backend.B5911189.Entity.SponsorRegis;
import com.se.team21.backend.B5911189.Entity.Transfer;
import com.se.team21.backend.B5911189.Entity.SponsorStatus;
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
    @Autowired  private  SponsorRegisRepository sponsorRegisRepository;
    @Autowired  private  SponsorStatusRepository sponsorStatusRepository;
    @Autowired  private  TransferRepository transferRepository;


    @Autowired SponsorRegisController (SponsorRegisRepository sponsorrepo){
        this.sponsorRegisRepository = sponsorrepo;
    }
    @GetMapping(path="/SponsorRegis",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SponsorRegis> SponsorRegis(){
        return sponsorRegisRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/SponsorRegis/{nameSponsorRegis}/{nameStatus}/{Address}/{nameTransfer}/{Amount}/{Phonenumber}")
    public SponsorRegis sponsorregis(  @PathVariable String nameSponsorRegis,@PathVariable String nameStatus,@PathVariable String Address,@PathVariable String nameTransfer,@PathVariable Double Amount,@PathVariable String Phonenumber )
    {

    SponsorRegis s = new SponsorRegis();
    SponsorStatus ss = sponsorStatusRepository.findBynameStatus(nameStatus);
    System.out.println(nameStatus);
    Transfer transfer = transferRepository.findBynameTransfer(nameTransfer);
    System.out.println(nameTransfer);

    s.setNameSponsorRegis(nameSponsorRegis);
    s.setSponsorStatus(ss);
    s.setAddress(Address);
    s.setTransfer(transfer);
    s.setAmount(Amount);
    s.setPhonenumber(Phonenumber);

    return sponsorRegisRepository.save(s);


}



}