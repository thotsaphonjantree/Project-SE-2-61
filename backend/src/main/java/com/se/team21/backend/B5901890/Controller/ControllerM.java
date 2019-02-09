package com.se.team21.backend.B5901890.Controller;

import com.se.team21.backend.B5901890.Entity.GenderStaff;
import com.se.team21.backend.B5901890.Entity.KindMedia;
import com.se.team21.backend.B5901890.Entity.KindSportMedia;
import com.se.team21.backend.B5901890.Entity.RegisterMedia;
import com.se.team21.backend.B5901890.Repository.GenderStaffRepository;
import com.se.team21.backend.B5901890.Repository.KindMediaRepository;
import com.se.team21.backend.B5901890.Repository.KindSportMediaRepository;
import com.se.team21.backend.B5901890.Repository.RegisterMediaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class ControllerM {

    @Autowired
    private RegisterMediaRepository registerMediaRepository;
    @Autowired
    private GenderStaffRepository genderStaffRepository;
    @Autowired
    private KindMediaRepository kindMediaRepository;
    @Autowired
    private KindSportMediaRepository kindSportMediaRepository;
    @Autowired
    public ControllerM(RegisterMediaRepository registerMediaRepository, GenderStaffRepository genderStaffRepository,
                       KindMediaRepository kindMediaRepository, KindSportMediaRepository kindSportMediaRepository){
    this.registerMediaRepository = registerMediaRepository;
    this.genderStaffRepository = genderStaffRepository;
    this.kindMediaRepository = kindMediaRepository;
    this.kindSportMediaRepository = kindSportMediaRepository;

    }
    @GetMapping(path = "/nameRegisterMedia/{nameRegisterMediaAA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterMedia getOneRegisterMedia(@PathVariable String RegisterMediaAA ){
        RegisterMedia registerMedia = new RegisterMedia();
        registerMedia.setName_Media(RegisterMediaAA);
        return registerMediaRepository.save(registerMedia);
    }
    @GetMapping(path = "/nameRegisterMediaA/{nameRegisterMediaAA}/{name_Company_MediaAA}/{tel}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterMedia getOneRegisterMedia(@PathVariable String RegisterMediaAA , @PathVariable String CompanyAA , @PathVariable String tel){
        RegisterMedia registerMedia = new RegisterMedia();
        registerMedia.setName_Media(RegisterMediaAA);
        registerMedia.setName_Company_Media(CompanyAA);//////////////

        registerMedia.setTel(tel);
        return registerMediaRepository.save(registerMedia);
    }
    @GetMapping(path = "/RegisterMedia", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RegisterMedia>  getOneRegisterMedia(){
        return this.registerMediaRepository.findAll().stream()
        .collect(Collectors.toList());
    }

    //---------------KindMedia-----------------------------------------------------------------------------------
    @GetMapping(path = "/KindMedia/{kindMediaA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public KindMedia getKind_Media(@PathVariable String kindMediaA){
        KindMedia kindMedia = new KindMedia();
        kindMedia.setKind_Media(kindMediaA);
        return kindMediaRepository.save(kindMedia);
    }
    @GetMapping("/kindMedia")
    public Collection<KindMedia> getKindMedia() {   /////////////////////////////////////////////////////////////////////
        return kindMediaRepository
                .findAll().stream().collect(Collectors.toList());
    }

   //------------Gender------------------------------------------------------------------------------------------
   @GetMapping(path = "/genders/{genderA}", produces = MediaType.APPLICATION_JSON_VALUE)
   public GenderStaff getNameGenderM(@PathVariable String genderA){
       GenderStaff genderStaff = new GenderStaff();
       genderStaff.setNameGender(genderA);
       return genderStaffRepository.save(genderStaff);
   }
    @GetMapping("/genders")
    public Collection<GenderStaff> getGenderStaff(){
        return  genderStaffRepository
                .findAll().stream().collect(Collectors.toList());
    }

    //--------------------KindSportMedia---------------------------------------------------------------------------------------
    @GetMapping(path = "/kindSportMedia/{kindSportMediaA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public KindSportMedia getKind_Sport(@PathVariable String kindSportMediaA){
        KindSportMedia a = new KindSportMedia();
        a.setKind_Sport(kindSportMediaA);
        return kindSportMediaRepository.save(a);
    }
    @GetMapping("/kindSportMedia")
    public Collection<KindSportMedia> getKindSportMedia() {
        return kindSportMediaRepository
                .findAll().stream().collect(Collectors.toList());
    }

    //------------------------------------------------------------------------------------------------------------------------------
    @GetMapping(path ="/RegisterMedia/{nameRegisterMediaA}/{kindMediaA}/{genderA}/{kindSportMediaA}/{name_Company_MediaAA}/{telA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterMedia newRegisterMedia(@PathVariable String nameRegisterMediaA, @PathVariable String kindMediaA,
                                          @PathVariable String genderA, @PathVariable String kindSportMediaA, @PathVariable String name_Company_MediaAA
                                         , @PathVariable String telA){



        RegisterMedia registerMedia = new RegisterMedia();
        registerMedia.setName_Media(nameRegisterMediaA);
        registerMedia.setName_Company_Media(name_Company_MediaAA);

        registerMedia.setTel(telA);

        KindMedia kindMediaAA = kindMediaRepository.findByName(kindMediaA);
        registerMedia.setKindMedia(kindMediaAA);

        GenderStaff genderAA = genderStaffRepository.findBynameGender(genderA);
        registerMedia.setGenderStaff(genderAA);

        KindSportMedia kindSportMediaAA = kindSportMediaRepository.findBynameKindsportMedia(kindSportMediaA);
        registerMedia.setKindSportMedia(kindSportMediaAA);


        return registerMediaRepository.save(registerMedia);

    }
}
//---------------------------------------------------------------------------------------------------------------

