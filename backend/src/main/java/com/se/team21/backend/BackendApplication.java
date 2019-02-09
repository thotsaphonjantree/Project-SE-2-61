package com.se.team21.backend;

import com.se.team21.backend.AnanB5911417.Entity.PlaceEvent;
import com.se.team21.backend.AnanB5911417.Repository.PlaceEventRepository;
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
import com.se.team21.backend.B5911189.Entity.Transfer;
import com.se.team21.backend.B5911189.Entity.SponsorRegis;
import com.se.team21.backend.B5911189.Entity.SponsorStatus;
import com.se.team21.backend.B5911189.Repository.AccountRecordRepository;
import com.se.team21.backend.B5911189.Repository.BankRepository;
import com.se.team21.backend.B5911189.Repository.FromToRepository;
import com.se.team21.backend.B5911189.Repository.IncomeExpensesRepository;
import com.se.team21.backend.B5911189.Repository.TransferRepository;
import com.se.team21.backend.B5911189.Repository.SponsorStatusRepository;
import com.se.team21.backend.B5911189.Repository.SponsorRegisRepository;
import com.se.team21.backend.B5926329.Entity.Payment;
import com.se.team21.backend.B5926329.Repository.EventRepository;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Repository.PayCategoryRepository;
import com.se.team21.backend.B5926329.Repository.PaymentRepository;

import java.util.Date;
import java.util.stream.Stream;

import com.se.team21.backend.B5926329.Sprint2.Entity.ExpertLevel;
import com.se.team21.backend.B5926329.Sprint2.Entity.JoinEventMember;
import com.se.team21.backend.B5926329.Sprint2.Repository.ExpertLevelRepository;
import com.se.team21.backend.B5926329.Sprint2.Repository.JoinEventMemberRepository;
import com.se.team21.backend.b5910311.entity.Location;
import com.se.team21.backend.b5910311.repository.LocationRepository;
import com.se.team21.backend.b5910311.entity.SportsType;
import com.se.team21.backend.b5910311.repository.SportsTypeRepository;
import com.se.team21.backend.b5910311.entity.SportsEventStaff;
import com.se.team21.backend.b5910311.repository.SportsEventStaffRepository;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.repository.SportsEventRepository;
import com.se.team21.backend.AnanB5911417.sp2.Entity.EventStore;
import com.se.team21.backend.AnanB5911417.sp2.Entity.StoreType;
import com.se.team21.backend.AnanB5911417.sp2.Repository.StoreTypeRepository;
import com.se.team21.backend.AnanB5911417.sp2.Repository.EventStoreRepository;
import com.se.team21.backend.b5910311.entity.Address;
import com.se.team21.backend.b5910311.repository.AddressRepository;
import com.se.team21.backend.b5910311.entity.Profile;
import com.se.team21.backend.b5910311.repository.ProfileRepository;

import com.se.team21.backend.B5901890.Entity.KindSportMedia;
import com.se.team21.backend.B5901890.Entity.GenderMedia;
import com.se.team21.backend.B5901890.Entity.KindMedia;
import com.se.team21.backend.B5901890.Repository.*;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
						   PlaceEventRepository placeEventRepository,
						   AgencyTypeRepository AgencyTypeRepository, CountryRepository CountryRepository,
						   ProvinceRepository ProvinceRepository, RelatedInformationRepository RelatedInformationRepository,
						   GenderStaffRepository genderStaffRepository, AgeStaffRepository ageStaffRepository,
						   WorkStaffRepository workStaffRepository,
						   RegisterStaffRepository registerStaffRepository,
						   AccountRecordRepository accountrecordrepository, BankRepository bankrepository,
						   FromToRepository fromtorepository, IncomeExpensesRepository incomeexpensesrepository,
						   LocationRepository locationRepository , SportsTypeRepository sportstypeRepository,
						   SportsEventStaffRepository sportseventstaffRepository, SportsEventRepository sportseventRepository, ProvinceRepository provinceRepository
						   , PersonTypeRepository personTypeRepository, RatingRepository ratingRepository,
						   ResultRepository resultRepository
						   , ExpertLevelRepository expertLevelRepository
						   , JoinEventMemberRepository joinEventMemberRepository,
						   StoreTypeRepository storeTypeRepository,EventStoreRepository eventStoreRepository,AddressRepository addressRepository,
						   ProfileRepository profileRepository,TransferRepository transferrepository,SponsorStatusRepository sponsorStatusRepository,SponsorRegisRepository sponsorRegisRepository,
						   BackendApplication backendApplication, GenderMediaRepository genderMediaRepository, KindSportMediaRepository kindSportMediaRepository,
						   KindMediaRepository kindMediaRepository,
						   RegisterMediaRepository registerMediaRepository){
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
		Stream.of("สนามสุรพลากรีฑาสถาน","สนามกีฬาเฉลิมพระเกียรติ 80 พรรษา","สนามกีฬาอเนกประสงค์พราหมณสุทธิ์","สนามกีฬากลาง มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน").forEach(placeName -> {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName(placeName);

			if(placeName == "สนามสุรพลากรีฑาสถาน"){
				placeEvent.setPlaceAddress("ตำบล สุรนารี อำเภอเมืองนครราชสีมา นครราชสีมา 30000");
				
			}
			else if(placeName == "สนามกีฬาเฉลิมพระเกียรติ 80 พรรษา"){
				placeEvent.setPlaceAddress("ตำบล สุรนารี อำเภอเมืองนครราชสีมา นครราชสีมา 30000");
				
			}
			else if(placeName == "สนามกีฬาอเนกประสงค์พราหมณสุทธิ์"){
				placeEvent.setPlaceAddress("ตำบล สุรนารี อำเภอเมืองนครราชสีมา นครราชสีมา 30000");
				
			}
			else if(placeName == "สนามกีฬากลาง มหาวิทยาลัยเทคโนโลยีราชมงคลอีสาน"){
				placeEvent.setPlaceAddress(" 744 ถนนสุรนารายณ์ ตำบล ในเมือง อำเภอเมืองนครราชสีมา นครราชสีมา 30000");
				
			}
			placeEventRepository.save(placeEvent);
		});

		
			//set Address
			Stream.of( "Nakhonratchasima","Bangkok","Khonkean" ).forEach( addressname ->{
				Address address = new Address();
				if(addressname=="Nakhonratchasima"){
				address.setAddressname(addressname);
				address.setCode("30000");
				}
				if(addressname=="Bangkok"){
				address.setAddressname(addressname);
				address.setCode("10000");
				}
				if(addressname=="Khonkean"){
				address.setAddressname(addressname);
				address.setCode("20000");
				}
				addressRepository.save(address); 
				});


			//set Profiles
			Stream.of( "Thotsaphon","Thaweechai" ).forEach( firstname ->{
				Profile profile = new Profile();
				if(firstname=="Thaweechai"){
					profile.setFirstName(firstname);
					profile.setLastName("Kanklang");
					profile.setAddressname(addressRepository.getOne(3L));
					profile.setName(memberRepository.getOne(2L));
				}
				if(firstname=="Thotsaphon"){
					profile.setFirstName(firstname);
					profile.setLastName("JanTree");
					profile.setAddressname(addressRepository.getOne(1L));
					profile.setName(memberRepository.getOne(1L));
				}
				profileRepository.save(profile); 
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
					sportsevent.setEventDetail("Bike For Mom ปั่นเพื่อแม่เป็นกิจกรรมที่เชิญชวนให้ทุกคนออกมาปั่นจักรยานออกกำลังกายเนื่องในวันแม่แห่งชาติ");
					sportsevent.setSportsType(sportstypeRepository.getOne(2L));
					sportsevent.setPrice(550l);
					sportsevent.setLocations(locationRepository.getOne(3L));
				}
				if(eventname=="Bike For Dad"){
					sportsevent.setEventName(eventname);
					sportsevent.setSesname(sportseventstaffRepository.getOne(1L));
					sportsevent.setEventDetail("Bike For Dad ปั่นเพื่อพ่อเป็นกิจกรรมที่เชิญชวนให้ทุกคนออกมาปั่นจักรยานออกกำลังกายเนื่องในวันพ่อแห่งชาติ");
					sportsevent.setSportsType(sportstypeRepository.getOne(2L));
					sportsevent.setPrice(750l);
					sportsevent.setLocations(locationRepository.getOne(1L));
				}
				if(eventname=="Kao Khon La Kao"){
					sportsevent.setEventName(eventname);
					sportsevent.setSesname(sportseventstaffRepository.getOne(2L));
					sportsevent.setEventDetail("Kao Khon La Kao วิ่งมาราธอนกับพี่ตูนสมทบทุนเพื่อซื้ออุปกรณ์ทางการแพทย์ให้กับโรงพยาบาลทั่วประเทศ");
					sportsevent.setSportsType(sportstypeRepository.getOne(1L));
					sportsevent.setPrice(100l);
					sportsevent.setLocations(locationRepository.getOne(2L));
				}
				sportseventRepository.save(sportsevent); 
				});
			//sportseventRepository.findAll().forEach(System.out::println);

		
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

			Stream.of("อันดับ 1", "อันดับ 2", "อันดับ 3").forEach(ratings -> {
				RatingEntity r = new RatingEntity();
				r.setRatingName(ratings);
				ratingRepository.save(r);
			});

			Stream.of("ปกติ", "พิการ").forEach(persontypes -> {
				PersonTypeEntity p = new PersonTypeEntity();
				p.setPersonTypeName(persontypes);
				personTypeRepository.save(p);
			});

			ResultEntity resultEntity1 = new ResultEntity();
			resultEntity1.setResultName("Mr.Narawich saphimarn");
			resultEntity1.setResultAddress("SUT");
			resultEntity1.setResultDate(new Date(29,04,29));
			SportsEvent sportsEvent1 = sportseventRepository.findByEventname("Bike For Mom");
			ProvinceEntity provinceEntity1 = provinceRepository.findByprovinceName("กรุงเทพมหานคร");
			SportsType sportsType1 = sportstypeRepository.findBySportname("Marathon");
			RatingEntity ratingEntity1 = ratingRepository.findByratingName("อันดับ 1");
			PersonTypeEntity personTypeEntity1 = personTypeRepository.findBypersonTypeName("ปกติ");
			resultEntity1.setSportsEvent(sportsEvent1);
			resultEntity1.setSportsType(sportsType1);
			resultEntity1.setProvinceEntity(provinceEntity1);
			resultEntity1.setRatingEntity(ratingEntity1);
			resultEntity1.setPersonTypeEntity(personTypeEntity1);
			resultRepository.save(resultEntity1);

			ResultEntity resultEntity2 = new ResultEntity();
			resultEntity2.setResultName("Ms.Kanjanaporn Boomeedai");
			resultEntity2.setResultAddress("Bankkok");
			resultEntity2.setResultDate(new Date(29,04,29));
			SportsEvent sportsEvent2 = sportseventRepository.findByEventname("Bike For Mom");
			ProvinceEntity provinceEntity2 = provinceRepository.findByprovinceName("กรุงเทพมหานคร");
			SportsType sportsType2 = sportstypeRepository.findBySportname("Marathon");
			RatingEntity ratingEntity2 = ratingRepository.findByratingName("อันดับ 2");
			PersonTypeEntity personTypeEntity2 = personTypeRepository.findBypersonTypeName("ปกติ");
			resultEntity2.setSportsEvent(sportsEvent2);
			resultEntity2.setSportsType(sportsType2);
			resultEntity2.setProvinceEntity(provinceEntity2);
			resultEntity2.setRatingEntity(ratingEntity2);
			resultEntity2.setPersonTypeEntity(personTypeEntity2);
			resultRepository.save(resultEntity2);

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
			Stream.of("บุคคลทั่วไป","หน่วยงาน หรือ บริษัท","------").forEach(fromtos -> {
				FromTo fromto = new FromTo();
				fromto.setNameFromTo(fromtos);
				fromtorepository.save(fromto);
			});

			//ExpertLevel
			Stream.of("ไม่มีประสบการณ์","มือสมัครเล่น","ระดับทั่วไป","ผู้เชี่ยวชาญ").forEach(expertLevelName -> {
				ExpertLevel expertLevel = new ExpertLevel();
				expertLevel.setExpertLevelName(expertLevelName);
				expertLevelRepository.save(expertLevel);
			});

			Stream.of("degea","pogba").forEach(tagName -> {
				JoinEventMember joinEventMember = new JoinEventMember();

				if(tagName == "degea"){
					joinEventMember.setTagName(tagName);
					joinEventMember.setPersonalId("0123456789123");
					joinEventMember.setMembers(memberRepository.getOne(1L));
					joinEventMember.setSportEvent(sportseventRepository.getOne(1L));
					joinEventMember.setTelNum("0123456789");
					joinEventMember.setExpertLevels(expertLevelRepository.getOne(2L));
				}
				if(tagName == "pogba"){
					joinEventMember.setTagName(tagName);
					joinEventMember.setPersonalId("3219876543210");
					joinEventMember.setMembers(memberRepository.getOne(2L));
					joinEventMember.setSportEvent(sportseventRepository.getOne(2L));
					joinEventMember.setTelNum("9876543210");
					joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));
				}
				joinEventMemberRepository.save(joinEventMember);
			});

			//type of store
			Stream.of("เครื่องดื่ม","ปิ้งย่าง","กับราดข้าว","ลูกชิ้น","ก๋วยเตี๊ยว","อาหารตามสั่ง").forEach(type -> {
				StoreType storeType = new StoreType();
				storeType.setTypeName(type);
				storeTypeRepository.save(storeType);
			});
			//SponsorTranfer
			Stream.of("เงินสด","เช็คเงินสด","โอนผ่านธนาคาร").forEach(transFer -> {
				Transfer transfer = new Transfer();
				transfer.setNameTransfer(transFer);
				transferrepository.save(transfer);
			});
			//SponsorStatus
			Stream.of("บุคคลทั่วไป","ร้านค้า","ห้างหุ้นส่วนจำกัด","บริษัท").forEach(status -> {
				SponsorStatus sponsorStatus = new SponsorStatus();
				sponsorStatus.setNameStatus(status);
				sponsorStatusRepository.save(sponsorStatus);
			});

			Stream.of("ช่างภาพ","นักข่าว","ถ่ายทอดสด","อาสาสมัคร").forEach(kindActivityss -> {
				KindMedia k = new KindMedia();
				k.setKind_Media(kindActivityss);
				kindMediaRepository.save(k);
			});
			Stream.of("ชาย","หญิง").forEach(genderss -> {
				GenderMedia Gender5 = new GenderMedia();
				Gender5.setNameGenderM(genderss);
				genderMediaRepository.save(Gender5);
			});

			Stream.of("ปั่นจักรยาน","วิ่งมาราธอน").forEach(agess -> {
				KindSportMedia sport = new KindSportMedia();
				sport.setKind_Sport(agess);
				kindSportMediaRepository.save(sport);
			});

		};
	};


} 	



