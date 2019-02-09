package com.se.team21.backend.B5901890.Controller;


import com.se.team21.backend.B5901890.Entity.AgeStaff;
import com.se.team21.backend.B5901890.Entity.GenderStaff;
import com.se.team21.backend.B5901890.Entity.RegisterStaff;
import com.se.team21.backend.B5901890.Entity.WorkStaff;
import com.se.team21.backend.B5901890.Repository.AgeStaffRepository;
import com.se.team21.backend.B5901890.Repository.GenderStaffRepository;
import com.se.team21.backend.B5901890.Repository.RegisterStaffRepository;
import com.se.team21.backend.B5901890.Repository.WorkStaffRepository;
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
public class Controller {

    @Autowired
    private RegisterStaffRepository registerStaffRepository;
    @Autowired
    private GenderStaffRepository genderStaffRepository;
    @Autowired
    private WorkStaffRepository workStaffRepository;
    @Autowired
    private AgeStaffRepository ageStaffRepository;
    @Autowired
    public Controller(RegisterStaffRepository registerStaffRepository, GenderStaffRepository genderStaffRepository,
                      WorkStaffRepository workStaffRepository, AgeStaffRepository ageStaffRepository){
    this.registerStaffRepository = registerStaffRepository;
    this.genderStaffRepository = genderStaffRepository;
    this.workStaffRepository = workStaffRepository;
    this.ageStaffRepository = ageStaffRepository;

    }

    //------------ Registerstaff---------------
    /*@GetMapping(path = "/activity/{activityA}/{peopleA/{ageA}}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Activity getActivity(@PathVariable String ActivityA, @PathVariable Integer peopleA, @PathVariable Date dayA){
        Activity activity = new Activity();
        activity.setNameActivity(ActivityA);
        activity.setPeople(peopleA);
        activity.setDay(dayA);


        return activityRepository.save(activity);
    } */
    @GetMapping(path = "/nameRegisterStaff/{nameRegisterStaffAA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterStaff getOneRegisterStaff(@PathVariable String RegisterStaffAA ){
        RegisterStaff registerStaff = new RegisterStaff();
        registerStaff.setNameRegisterStaff(RegisterStaffAA);
        return registerStaffRepository.save(registerStaff);
    }
    @GetMapping(path = "/nameRegisterStaffA/{nameRegisterStaffAA}/{tellAA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterStaff getOneRegisterStaffA(@PathVariable String RegisterStaffAA , @PathVariable String tellAA){
        RegisterStaff registerStaff = new RegisterStaff();
        registerStaff.setNameRegisterStaff(RegisterStaffAA);
        registerStaff.setTell(tellAA);

        return registerStaffRepository.save(registerStaff);
    }
    @GetMapping(path = "/RegisterStaff", produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<RegisterStaff>  getOneRegisterStaff(){
        return this.registerStaffRepository.findAll().stream()
        .collect(Collectors.toList());
    }


    //---------------WorkStaff-----------------------------------------------------------------------------------
    @GetMapping(path = "/WorkStaff/{workA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public WorkStaff getWork(@PathVariable String workA){
        WorkStaff workStaff = new WorkStaff();
        workStaff.setWork(workA);
        return workStaffRepository.save(workStaff);
    }
    @GetMapping("/workStaff")
    public Collection<WorkStaff> getWorkStaff() {
        return workStaffRepository
                .findAll().stream().collect(Collectors.toList());

    }

   //------------Gender------------------------------------------------------------------------------------------
   @GetMapping(path = "/gender/{genderA}", produces = MediaType.APPLICATION_JSON_VALUE)
   public GenderStaff getNameGender(@PathVariable String genderA){
       GenderStaff genderStaff = new GenderStaff();
       genderStaff.setNameGender(genderA);
       return genderStaffRepository.save(genderStaff);
   }
    @GetMapping("/genders")
    public Collection<GenderStaff> getGenderStaff(){
        return  genderStaffRepository
                .findAll().stream().collect(Collectors.toList());
    }
    //@GetMapping("/gender/{idGender}")
    // public Gender getOneGender(@PathVariable Long idGender ){
    //  return genderRepository.findById(idGender).get();
    // }
    //--------------------Age---------------------------------------------------------------------------------------
    @GetMapping(path = "/age/{ageA}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AgeStaff getAge(@PathVariable Integer ageA){
        AgeStaff a = new AgeStaff();
        a.setAge(ageA);
        return ageStaffRepository.save(a);
    }
    @GetMapping("/age")
    public Collection<AgeStaff> getAge() {
        return ageStaffRepository
                .findAll().stream().collect(Collectors.toList());
    }
    //@GetMapping(path = "/age/{idAge}", produces = MediaType.APPLICATION_JSON_VALUE)
    // public Age getOneAge(@PathVariable Long idAge ){
    //    return ageRepository.findById(idAge).get();
    // }


    @GetMapping(path ="/RegisterStaff/{nameRegisterStaffA}/{workA}/{genderA}/{AgeA}/{tell}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RegisterStaff newRegisterStaff(@PathVariable String nameRegisterStaffA, @PathVariable String workA,
                                          @PathVariable String genderA, @PathVariable Integer AgeA, @PathVariable String tell){



        RegisterStaff registerStaff = new RegisterStaff();
        registerStaff.setNameRegisterStaff(nameRegisterStaffA);
        registerStaff.setTell(tell);

        WorkStaff workAA = workStaffRepository.findByName(workA);
        registerStaff.setWorkStaff(workAA);

        GenderStaff genderAA = genderStaffRepository.findBynameGender(genderA);
        registerStaff.setGenderStaff(genderAA);

        AgeStaff ageA = ageStaffRepository.findBynameAge(AgeA);
        registerStaff.setAgeStaff(ageA);


        return registerStaffRepository.save(registerStaff);

    }
}





//---------------------------------------------------------------------------------------------------------------

