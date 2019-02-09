package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.*;
import com.se.team21.backend.b5910311.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SportsEventController {

    @Autowired
    private SportsEventRepository sportseventRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SportsTypeRepository sportstypeRepository;

    @Autowired
    private SportsEventStaffRepository sportEventStaffRepository;

    @GetMapping("/event")
    public List<SportsEvent> showAllSportsEvent() {
        return sportseventRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/event/{seid}")
    public SportsEvent ShowSportsEvent(@PathVariable Long seid) {
        Optional<SportsEvent> sportsevent = sportseventRepository.findById(seid);
        return sportsevent.get();
    }

     @PostMapping(path = "/event/{eventName}/{eventDetail}/{sportName}/{locations}/{sesName}/{price}")
    public SportsEvent sportsevent(@PathVariable String eventName,
                                       @PathVariable String eventDetail, @PathVariable Long sportName,
                                       @PathVariable Long locations, @PathVariable Long sesName,
                                       @PathVariable Long price){

        SportsEvent sportsevent = new SportsEvent();

        sportsevent.setEventName(eventName);
        sportsevent.setEventDetail(eventDetail);
        sportsevent.setSportsType(sportstypeRepository.getOne(sportName));
        sportsevent.setLocations(locationRepository.getOne(locations));
        sportsevent.setSesname(sportEventStaffRepository.getOne(sesName));
        sportsevent.setPrice(price);

        return sportseventRepository.save(sportsevent);


    }
    @PutMapping(path = "/updateevent/{seid}/{eventName}/{eventDetail}/{sportName}/{locations}/{sesName}/{price}")
    public SportsEvent editsportsevent(@RequestBody SportsEvent editsportsevent,
                                     @PathVariable Long seid,@PathVariable String eventName,
                                       @PathVariable String eventDetail, @PathVariable Long sportName,
                                       @PathVariable Long locations, @PathVariable Long sesName,
                                       @PathVariable Long price){
        SportsType st = sportstypeRepository.getOne(sportName);
        Location lo = locationRepository.getOne(locations);
        SportsEventStaff ses = sportEventStaffRepository.getOne(sesName);
        return sportseventRepository.findById(seid).map(eventEdit ->{
            eventEdit.setSEid(seid);
            eventEdit.setEventName(eventName);
            eventEdit.setEventDetail(eventDetail);
            eventEdit.setSportsType(st);
            eventEdit.setLocations(lo);
            eventEdit.setSesname(ses);
            eventEdit.setPrice(price);
            

                    return sportseventRepository.save(eventEdit);
                }
        ).orElseGet(() ->{
            return sportseventRepository.save(editsportsevent);
        });
    }

}