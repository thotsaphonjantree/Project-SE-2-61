package com.se.team21.backend;

import com.se.team21.backend.b5910311.entity.*;
import com.se.team21.backend.b5910311.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.PersistenceException;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class Sprint1b5910311Test {

    @Autowired
    private SportsEventRepository sportseventRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private SportsTypeRepository sportstypeRepository;

    @Autowired
    private SportsEventStaffRepository sporteventstaffRepository;

    @Autowired
	private TestEntityManager entityManager;

	private Validator validator;

    @Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

    @Test
	public void testLocationSuccess() {
        Location location = new Location();
		location.setLocations("Buriram");
		try {
			entityManager.persist(location);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}

	}

    @Test
	public void testLocationNotBeNull() {
        Location location = new Location();
		location.setLocations(null);
		try {
			entityManager.persist(location);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test1 testLocationNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test1 testLocationNotBeNull");
		}
	}

    @Test
	public void testSportsTypeSuccess() {
        SportsType sportstype = new SportsType();
		sportstype.setSportName("Swimming");
		try {
			entityManager.persist(sportstype);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}
	}

    @Test
	public void testSportsTypeNotBeNull() {
        SportsType sportstype = new SportsType();
		sportstype.setSportName(null);
		try {
			entityManager.persist(sportstype);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test2 testSportsTypeNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test2 testSportsTypeNotBeNull");
		}
	}

    @Test
	public void testSportsEventStaffSuccess() {
        SportsEventStaff sportseventstaff = new SportsEventStaff();
		sportseventstaff.setSesName("Nick");
		try {
			entityManager.persist(sportseventstaff);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}
	}

    @Test
	public void testSportsEventStaffNotBeNull() {
        SportsEventStaff sportseventstaff = new SportsEventStaff();
		sportseventstaff.setSesName(null);
		try {
			entityManager.persist(sportseventstaff);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test3 testSportsEventStaffNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test3 testSportsEventStaffNotBeNull");
		}
	}

    @Test
	public void testSportsEventSuccess() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName("Bike For Win");
		sportsevent.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent.setPrice(550l);
		sportsevent.setLocations(locationRepository.getOne(3L));
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}
	}

    @Test
	public void testEventNameNotBeNull() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName(null);
		sportsevent.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent.setPrice(550l);
		sportsevent.setLocations(locationRepository.getOne(3L));
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test4 testEventNameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test4 testEventNameNotBeNull");
		}
	}

    @Test
	public void testEventSesnameNotBeNull() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName("Bike For Win");
		sportsevent.setSesname(null);
		sportsevent.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent.setPrice(550l);
		sportsevent.setLocations(locationRepository.getOne(3L));
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test5 testSesnameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test5 testSesnameNotBeNull");
		}
	}

    @Test
	public void testEventDetailNotBeNull() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName("Bike For Win");
		sportsevent.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent.setEventDetail(null);
		sportsevent.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent.setPrice(550l);
		sportsevent.setLocations(locationRepository.getOne(3L));
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test6 testEventDetailBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test6 testEventDetailBeNull");
		}
	}

    @Test
	public void testEventSportsTypeNotBeNull() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName("Bike For Win");
		sportsevent.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent.setSportsType(null);
		sportsevent.setPrice(550l);
		sportsevent.setLocations(locationRepository.getOne(3L));
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test7 testEventSportsTypeNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test7 testEventSportsTypeNotBeNull");
		}
	}

    @Test
	public void testEventPriceNotBeNull() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName("Bike For Win");
		sportsevent.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent.setPrice(null);
		sportsevent.setLocations(locationRepository.getOne(3L));
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test8 testEventPriceNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test8 testEventPriceNotBeNull");
		}
	}
    
    @Test
	public void testEventLocationNotBeNull() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName("Bike For Win");
		sportsevent.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent.setPrice(550l);
		sportsevent.setLocations(null);
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test9 testEventLocationNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test9 testEventLocationNotBeNull");
		}
	}

    @Test
	public void testEventNameMustBeUnique() {
        SportsEvent sportsevent1 = new SportsEvent();
		sportsevent1.setEventName("Bike For Win");
		sportsevent1.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent1.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent1.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent1.setPrice(550l);
		sportsevent1.setLocations(locationRepository.getOne(3L));
        entityManager.persist(sportsevent1);
		entityManager.flush();

        SportsEvent sportsevent2 = new SportsEvent();
		sportsevent2.setEventName("Bike For Win");
		sportsevent2.setSesname(sporteventstaffRepository.getOne(2L));
		sportsevent2.setEventDetail("Bike For Lose ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent2.setSportsType(sportstypeRepository.getOne(1L));
		sportsevent2.setPrice(550l);
		sportsevent2.setLocations(locationRepository.getOne(2L));
		try {
			entityManager.persist(sportsevent2);
			entityManager.flush();
			fail("Should not pass to this line");
        }
		catch(javax.persistence.PersistenceException e){
			System.out.println("Test10 testEventNameMustBeUnique ===========");
			System.out.println(e);
			System.out.println("==============Test10 testEventNameMustBeUnique");
		}
	}

    @Test
	public void testEventNameMustCharacter() {
        SportsEvent sportsevent = new SportsEvent();
		sportsevent.setEventName("6516516");
		sportsevent.setSesname(sporteventstaffRepository.getOne(1L));
		sportsevent.setEventDetail("Bike For Win ปั่นเพื่อออกกำลังกายเป็นกิจกรรมที่สนับสนุนการออกกำลังกาย");
		sportsevent.setSportsType(sportstypeRepository.getOne(2L));
		sportsevent.setPrice(550l);
		sportsevent.setLocations(locationRepository.getOne(3L));
		try {
			entityManager.persist(sportsevent);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test11 testEventNameMustCharacter ==============");
			System.out.println(e);
			System.out.println("================Test11 testEventNameMustCharacter");
		}
    }

    @Test
	public void testLocationOverThan20() {
        Location location = new Location();
		location.setLocations("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		try {
			entityManager.persist(location);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test12 testCodeOverThan5 ==============");
			System.out.println(e);
			System.out.println("================= Test12 testCodeOverThan5");
		}
    }

    @Test
	public void testLocationLessThan5() {
        Location location = new Location();
		location.setLocations("ABCD");
		try {
			entityManager.persist(location);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test13 testCodeOverThan5 ==============");
			System.out.println(e);
			System.out.println("================= Test13 testCodeOverThan5");
		}
    }

}