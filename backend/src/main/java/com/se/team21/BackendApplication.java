package com.se.team21.backend;

<<<<<<< HEAD
import com.se.team21.backend.AnanB5911417.Entity.PlaceEvent;
import com.se.team21.backend.AnanB5911417.Entity.SportEvent;
import com.se.team21.backend.AnanB5911417.Entity.Staff;
import com.se.team21.backend.AnanB5911417.Repository.PlaceEventRepository;
import com.se.team21.backend.AnanB5911417.Repository.SportEventRepository;
import com.se.team21.backend.AnanB5911417.Repository.StaffRepository;
import com.se.team21.backend.B5926329.Entity.Event;
import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Entity.PayCategory;
import com.se.team21.backend.B5926329.Entity.Payment;
import com.se.team21.backend.B5926329.Repository.EventRepository;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Repository.PayCategoryRepository;
import com.se.team21.backend.B5926329.Repository.PaymentRepository;
=======
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


>>>>>>> issue-51
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
<<<<<<< HEAD
    ApplicationRunner init(MemberRepository memberRepository, PayCategoryRepository payCategoryRepository,
						   EventRepository eventRepository, PaymentRepository paymentRepository,
						   PlaceEventRepository placeEventRepository,SportEventRepository sportEventRepository,
						   StaffRepository staffRepository){
		return args -> {

			/*Member*/ Stream.of( "david01","paul06").forEach(username -> {
				Member member = new Member();
				member.setUsername(username);

				if(username == "david01"){
					member.setPassword("1111");
					member.setName("daviddegea");
				}
				else if(username == "paul06"){
					member.setPassword("6666");
					member.setName("paulpogba");
				}
				memberRepository.save(member);
			});

			/*PayCategory*/Stream.of("Wallet","PayPal").forEach(paycate -> {
				PayCategory payCategory = new PayCategory();
				payCategory.setPaycateName(paycate);
				payCategoryRepository.save(payCategory);
			});

			/*Event*/Stream.of("Running","Swimming").forEach(evt -> {
				Event event = new Event();
				event.setEvenName(evt);
					if(evt == "Running"){
						event.setEvenPrice(500L);
					}
					else if(evt == "Swimming"){
						event.setEvenPrice(300L);
					}
				eventRepository.save(event);
			});


            /*Payments*/Stream.of(300L,500L).forEach(paid -> {
                Payment payment = new Payment();
                payment.setPaymentPaid(paid);
                if(paid == 300L){
                    payment.setMembers(memberRepository.getOne(2L));
                    payment.setPayCategory(payCategoryRepository.getOne(1L));
                    payment.setSportEvent(eventRepository.getOne(2L));
                }
                else if(paid == 500L){
                    payment.setMembers(memberRepository.getOne(1L));
                    payment.setPayCategory(payCategoryRepository.getOne(2L));
                    payment.setSportEvent(eventRepository.getOne(1L));
                }
                paymentRepository.save(payment);
            });
		
		
		/*PlaceEvent*/
		Stream.of("eightyyear","route66").forEach(placeName -> {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName(placeName);

			if(placeName == "eightyyear"){
				placeEvent.setPlaceAddress("nakornratchasrima");
				
			}
			else if(placeName == "route66"){
				placeEvent.setPlaceAddress("petchaboon");
				
			}
			placeEventRepository.save(placeEvent);
		});

		/*SportEvent*/
		Stream.of("run for mom","bike for dad","fight for kid").forEach(eventName -> {
			SportEvent sportEvent = new SportEvent();
			sportEvent.setEventName(eventName);

			if(eventName == "run for mom"){
				sportEvent.setLocation("nakornratchasrima");
				sportEvent.setSportName("running");
			}
			else if(eventName == "bike for dad"){
				sportEvent.setLocation("petchaboon");
				sportEvent.setSportName("bicycle");
			}
			else if(eventName == "fight for kid"){
				sportEvent.setLocation("Phitsanoloke");
				sportEvent.setSportName("bicycle");
			}
			sportEventRepository.save(sportEvent);
		});

		/*Staff*/
		Stream.of("jump","pae","phee").forEach(staffName -> {
			Staff staff = new Staff();
			staff.setStaffName(staffName);

			staffRepository.save(staff);
		});
=======
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

			
>>>>>>> issue-51

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
<<<<<<< HEAD
		};

=======
>>>>>>> issue-51

	} 	


