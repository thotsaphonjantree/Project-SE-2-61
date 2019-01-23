package com.se.team21.backend;

import java.util.stream.Stream;

import com.se.team21.backend.b5910311.entity.Location;
import com.se.team21.backend.b5910311.repository.LocationRepository;
import com.se.team21.backend.b5910311.entity.SportsType;
import com.se.team21.backend.b5910311.repository.SportsTypeRepository;
import com.se.team21.backend.b5910311.entity.SportsEventStaff;
import com.se.team21.backend.b5910311.repository.SportsEventStaffRepository;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.repository.SportsEventRepository;
import com.se.team21.backend.b5910311.entity.SeSt;
import com.se.team21.backend.b5910311.repository.SeStRepository;


import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
    ApplicationRunner init( LocationRepository locationRepository , SportsTypeRepository sportstypeRepository,
							SportsEventStaffRepository sportseventstaffRepository,SportsEventRepository sportseventRepository,
							SeStRepository sestRepository){
		return args -> {

			//set location
			Stream.of( "Nakhonratchasima","Bangkok","Khonkean" ).forEach( locations ->{
				Location location = new Location();
				location.setLocations(locations);
				locationRepository.save(location); 
				});
			//locationRepository.findAll().forEach(System.out::println);

			//set sportstype
			Stream.of( "Marathon","Ride Bicycle").forEach( sportname ->{
				SportsType sportstype = new SportsType();
				sportstype.setSportName(sportname);
				sportstypeRepository.save(sportstype); 
				});
			//sportstypeRepository.findAll().forEach(System.out::println);

			//set sportseventstaff
			Stream.of("Pae","Nay").forEach( sesname ->{
				SportsEventStaff sportseventstaff = new SportsEventStaff();
				sportseventstaff.setSesName(sesname);
				sportseventstaffRepository.save(sportseventstaff); 
				});
			//sportseventstaffRepository.findAll().forEach(System.out::println);

			

			//set sportsevent
			Stream.of("Bike For Mom","Bike For Dad","Kao Khon La Kao").forEach( eventname ->{
				SportsEvent sportsevent = new SportsEvent();
				if(eventname=="Bike For Mom"){
					sportsevent.setEventName(eventname);
					sportsevent.setSesname(sportseventstaffRepository.getOne(1L));
					sportsevent.setPrice(550l);
					sportsevent.setLocations(locationRepository.getOne(3L));
					sportseventRepository.save(sportsevent); 
				}
				if(eventname=="Bike For Dad"){
					sportsevent.setEventName(eventname);
					sportsevent.setSesname(sportseventstaffRepository.getOne(1L));
					sportsevent.setPrice(750l);
					sportsevent.setLocations(locationRepository.getOne(1L));
					sportseventRepository.save(sportsevent); 
				}
				if(eventname=="Kao Khon La Kao"){
					sportsevent.setEventName(eventname);
					sportsevent.setSesname(sportseventstaffRepository.getOne(2L));
					sportsevent.setPrice(100l);
					sportsevent.setLocations(locationRepository.getOne(2L));
					sportseventRepository.save(sportsevent); 
				}
				sportseventRepository.save(sportsevent); 
				});
			//sportseventRepository.findAll().forEach(System.out::println);

			//set sest
			Stream.of(1l,2l,3l).forEach( id ->{
				SeSt sest = new SeSt();
				sest.setId(id);
				if(id == 1l){
					sest.setSportName(sportstypeRepository.getOne(1L));
					sest.setEventName(sportseventRepository.getOne(3L));
				}
				if(id == 2l){
					sest.setSportName(sportstypeRepository.getOne(2L));
					sest.setEventName(sportseventRepository.getOne(1L));
				}
				if(id == 3l){
					sest.setSportName(sportstypeRepository.getOne(2L));
					sest.setEventName(sportseventRepository.getOne(2L));
				}
				
				sestRepository.save(sest);
				});
			//sestRepository.findAll().forEach(System.out::println);
		};

	} 	

}

