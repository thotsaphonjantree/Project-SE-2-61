package com.se.team21.backend.AnanB5911417.Controller;

import com.se.team21.backend.AnanB5911417.Entity.PlaceEvent;
import com.se.team21.backend.AnanB5911417.Entity.ReservePlace;
import com.se.team21.backend.AnanB5911417.Repository.PlaceEventRepository;
import com.se.team21.backend.AnanB5911417.Repository.ReservePlaceRepository;
import com.se.team21.backend.B5901890.Entity.RegisterStaff;
import com.se.team21.backend.b5910311.controller.SportsEventController;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.repository.SportsEventRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PlaceEventController {

    @Autowired
    PlaceEventRepository placeEventRepository;
    @Autowired
    ReservePlaceRepository reservePlaceRepository;
    @Autowired
    com.se.team21.backend.B5901890.Repository.RegisterStaffRepository staffRepository;
    @Autowired
    com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;

    @GetMapping("/placeevent")
    public List<PlaceEvent> showAllPlaceEvent(){
        return placeEventRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/sportevent")
    public List<SportsEvent> showAllSportEvent(){
        return sportsEventRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/showstaff")
    public List<RegisterStaff> showAllStaff(){
        return staffRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/reserve")
    public List<ReservePlace> showAllReserve(){
        return reservePlaceRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/reserve/create/{eventI}/{placeI}/{staffI}/{Sdate}/{Edate}")
    public ReservePlace createReservePlace(@PathVariable Long eventI,
                                         @PathVariable Long placeI,
                                         @PathVariable Long staffI,
                                         @PathVariable Date Sdate,
                                         @PathVariable Date Edate)
     {
       
        ReservePlace reservePlace = new ReservePlace();
        
        reservePlace.setSportEventF(sportsEventRepository.getOne(eventI));
        reservePlace.setPlaceEventF(placeEventRepository.getOne(placeI));
        reservePlace.setStaffF(staffRepository.getOne(staffI));
        reservePlace.setEdate(Edate);
        reservePlace.setSdate(Sdate);
            return reservePlaceRepository.save(reservePlace);
    }

}
