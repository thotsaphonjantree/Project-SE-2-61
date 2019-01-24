package com.se.team21.backend;

import com.se.team21.backend.AnanB5911417.Entity.PlaceEvent;
import com.se.team21.backend.AnanB5911417.Entity.SportEvent;
import com.se.team21.backend.AnanB5911417.Entity.Staff;
import com.se.team21.backend.AnanB5911417.Repository.PlaceEventRepository;
import com.se.team21.backend.AnanB5911417.Repository.SportEventRepository;
import com.se.team21.backend.AnanB5911417.Repository.StaffRepository;
import com.se.team21.backend.B5901890.Entity.AgeStaff;
import com.se.team21.backend.B5901890.Entity.GenderStaff;
import com.se.team21.backend.B5901890.Entity.WorkStaff;
import com.se.team21.backend.B5901890.Repository.AgeStaffRepository;
import com.se.team21.backend.B5901890.Repository.GenderStaffRepository;
import com.se.team21.backend.B5901890.Repository.RegisterStaffRepository;
import com.se.team21.backend.B5901890.Repository.WorkStaffRepository;
import com.se.team21.backend.B5926329.Entity.Event;
import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Entity.PayCategory;
import com.se.team21.backend.B5911189.Entity.AccountRecord;
import com.se.team21.backend.B5911189.Entity.Banks;
import com.se.team21.backend.B5911189.Entity.FromTo;
import com.se.team21.backend.B5911189.Entity.IncomeExpenses;
import com.se.team21.backend.B5911189.Repository.AccountRecordRepository;
import com.se.team21.backend.B5911189.Repository.BankRepository;
import com.se.team21.backend.B5911189.Repository.FromToRepository;
import com.se.team21.backend.B5911189.Repository.IncomeExpensesRepository;
import com.se.team21.backend.B5926329.Entity.Payment;
import com.se.team21.backend.B5926329.Repository.EventRepository;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Repository.PayCategoryRepository;
import com.se.team21.backend.B5926329.Repository.PaymentRepository;
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

import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import com.se.team21.backend.B5909711.Entity.*;
import com.se.team21.backend.B5909711.Repository.*;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
    ApplicationRunner init(MemberRepository memberRepository, PayCategoryRepository payCategoryRepository,
						   EventRepository eventRepository, PaymentRepository paymentRepository,
						   PlaceEventRepository placeEventRepository, SportEventRepository sportEventRepository,
						   StaffRepository staffRepository, LocationRepository locationRepository , SportsTypeRepository sportstypeRepository,
						   SportsEventStaffRepository sportseventstaffRepository, SportsEventRepository sportseventRepository,
						   SeStRepository sestRepository, AgencyTypeRepository AgencyTypeRepository, CountryRepository CountryRepository,
						   ProvinceRepository ProvinceRepository, RelatedInformationRepository RelatedInformationRepository,
						   ActivitiesRepository ActivitiesRepository, TestRepository testRepository,
						   GenderStaffRepository genderStaffRepository, AgeStaffRepository ageStaffRepository,
						   WorkStaffRepository workStaffRepository,
						   RegisterStaffRepository registerStaffRepository,
						   AccountRecordRepository accountrecordrepository, BankRepository bankrepository,
						   FromToRepository fromtorepository, IncomeExpensesRepository incomeexpensesrepository){
		return args -> {

			/*Member*/ Stream.of( "david01","paul06").forEach(username -> {
				Member member = new Member();
				member.setUsername(username);

				if(username == "david01"){
					member.setPassword("1111");
					member.setName("David De Gea");
				}
				else if(username == "paul06"){
					member.setPassword("6666");
					member.setName("Paul Pogba");
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
				event.setEventName(evt);
					if(evt == "Running"){
						event.setEventPrice(500L);
					}
					else if(evt == "Swimming"){
						event.setEventPrice(300L);
					}
				eventRepository.save(event);
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

		// /*SportEvent*/
		// Stream.of("run for mom","bike for dad","fight for kid").forEach(eventName -> {
		// 	SportEvent sportEvent = new SportEvent();
		// 	sportEvent.setEventName(eventName);

		// 	if(eventName == "run for mom"){
		// 		sportEvent.setLocation("nakornratchasrima");
		// 		sportEvent.setSportName("running");
		// 	}
		// 	else if(eventName == "bike for dad"){
		// 		sportEvent.setLocation("petchaboon");
		// 		sportEvent.setSportName("bicycle");
		// 	}
		// 	else if(eventName == "fight for kid"){
		// 		sportEvent.setLocation("Phitsanoloke");
		// 		sportEvent.setSportName("bicycle");
		// 	}
		// 	sportEventRepository.save(sportEvent);
		// });

		/*Staff*/
		Stream.of("jump","pae","phee").forEach(staffName -> {
			Staff staff = new Staff();
			staff.setStaffName(staffName);

			staffRepository.save(staff);
		});

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
				}
				if(eventname=="Bike For Dad"){
					sportsevent.setEventName(eventname);
					sportsevent.setSesname(sportseventstaffRepository.getOne(1L));
					sportsevent.setPrice(750l);
					sportsevent.setLocations(locationRepository.getOne(1L));
				}
				if(eventname=="Kao Khon La Kao"){
					sportsevent.setEventName(eventname);
					sportsevent.setSesname(sportseventstaffRepository.getOne(2L));
					sportsevent.setPrice(100l);
					sportsevent.setLocations(locationRepository.getOne(2L));
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

			/*Payments Stream.of(300L,750L).forEach(paid -> {
				Payment payment = new Payment();
				payment.setPaymentPaid(paid);
				if(paid == 750L){
					payment.setMembers(memberRepository.getOne(2L));
					payment.setPayCategory(payCategoryRepository.getOne(1L));
					payment.setSportEvent(sportseventRepository.getOne(2L));
				}
				else if(paid == 550L){
					payment.setMembers(memberRepository.getOne(1L));
					payment.setPayCategory(payCategoryRepository.getOne(2L));
					payment.setSportEvent(sportseventRepository.getOne(1L));
				}
				paymentRepository.save(payment);
			});*/


			Stream.of("กรุงเทพมหานคร", "กระบี่", "กาญจนบุรี", "กาฬสินธุ์", "กำแพงเพชร", "ขอนแก่น", "จันทบุรี", "ฉะเชิงเทรา", "ชลบุรี", "ชัยนาท"
					, "ชัยภูมิ", "ชุมพร", "เชียงราย", "เชียงใหม่", "ตรัง", "ตราด", "ตาก", "นครนายก", "นครปฐม", "นครพนม", "นครราชสีมา", "นครศรีธรรมราช"
					, "นครสวรรค์", "นนทบุรี", "นราธิวาส", "น่าน", "บึงกาฬ", "บุรีรัมย์", "ปทุมธานี", "ประจวบคีรีขันธ์", "ปราจีนบุรี", "ปัตตานี", "พระนครศรีอยุธยา"
					, "พังงา", "พัทลุง", "พิจิตร", "พิษณุโลก", "เพชรบุรี", "เพชรบูรณ์", "แพร่", "พะเยา", "ภูเก็ต", "มหาสารคาม", "มุกดาหาร", "แม่ฮ่องสอน"
					, "ยะลา", "ยโสธร", "ร้อยเอ็ด", "ระนอง", "ระยอง", "ราชบุรี", "ลพบุรี", "ลำปาง", "ลำพูน", "เลย", "ศรีสะเกษ", "สกลนคร", "สงขลา", "สตูล"
					, "สมุทรปราการ", "สมุทรสงคราม", "สมุทรสาคร", "สระแก้ว", "สระบุรี", "สิงห์บุรี", "สุโขทัย", "สุพรรณบุรี", "สุราษฎร์ธานี", "สุรินทร์", "หนองคาย"
					, "หนองบัวลำภู", "อ่างทอง", "อุดรธานี", "อุทัยธานี", "อุตรดิตถ์", "อุบลราชธานี", "อำนาจเจริญ").forEach(provinces -> {
				ProvinceEntity province = new ProvinceEntity();
				province.setProvinceName(provinces);
				ProvinceRepository.save(province);
			});

			Stream.of("Thailand", "Australia", "Canada", "USA").forEach(countrys -> {
				CountryEntity country = new CountryEntity();
				country.setCountryName(countrys);
				CountryRepository.save(country);
			});

			Stream.of("โรงพยาบาล", "สถานีตำรวจ", "มูลนิธิ").forEach(agencyTypes -> {
				AgencyTypeEntity agencyType = new AgencyTypeEntity();
				agencyType.setAgencyName(agencyTypes);
				AgencyTypeRepository.save(agencyType);
			});

			Stream.of("ปั่นอุ่นไอรัก", "วิ่งเพื่อสุขภาพ").forEach(activities -> {
				ActivitiesEntity activitie = new ActivitiesEntity();
				activitie.setActivitiesName(activities);
				ActivitiesRepository.save(activitie);
			});

			TestEntity test1 = new TestEntity();
			test1.settActivities("ปั่นอุ่นไอรัก");
			test1.settAddress("สนามหลวง");
			test1.settName("NS");
			testRepository.save(test1);

			TestEntity test2 = new TestEntity();
			test2.settActivities("วิ่งเพื่อสุขภาพ");
			test2.settAddress("SUT");
			test2.settName("NS");
			testRepository.save(test2);



			Stream.of("ลงทะเบียนนักกีฬา","ดูแลนักกีฬา","จัดสถานที่").forEach(kindActivitys -> {
				WorkStaff k = new WorkStaff();
				k.setWork(kindActivitys);
				workStaffRepository.save(k);
			});
			Stream.of("ชาย","หญิง").forEach(genders -> {
				GenderStaff Gender5 = new GenderStaff();
				Gender5.setNameGender(genders);
				genderStaffRepository.save(Gender5);
			});

			Stream.of(18,19,20,21,22,23,24,25,26,27,28,29,30).forEach(ages -> {
				AgeStaff age = new AgeStaff();
				age.setAge(ages);
				ageStaffRepository.save(age);
			});
			//Income
			Stream.of("รายรับ","รายจ่าย").forEach(incomes -> {
				IncomeExpenses income = new IncomeExpenses();
				income.setIncomeExpenses(incomes);
				incomeexpensesrepository.save(income);
			});
			//Bank
			Stream.of("ธนาคารกรุงศรีอยุธยา ","ธนาคารกรุงเทพ","ธนาคารกรุงไทย","ธนาคารกสิกรไทย","ธนาคารไทยพาณิชย์").forEach(Bank -> {
				Banks banks = new Banks();
				banks.setNameBank(Bank);
				bankrepository.save(banks);
			});
			//Fromto
			Stream.of("บุคคลทั่วไป","หน่วยงาน/บริษัท","------").forEach(fromtos -> {
				FromTo fromto = new FromTo();
				fromto.setNameFromTo(fromtos);
				fromtorepository.save(fromto);
			});


		};
	};


} 	



