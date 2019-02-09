package com.se.team21.backend;
import java.util.Date;
import com.se.team21.backend.AnanB5911417.sp2.Repository.*;
import com.se.team21.backend.AnanB5911417.sp2.Entity.*;

import com.se.team21.backend.AnanB5911417.Repository.*;
import com.se.team21.backend.AnanB5911417.Entity.*;

import com.se.team21.backend.b5910311.repository.SportsEventRepository;
import com.se.team21.backend.b5910311.entity.SportsEvent;

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
import javax.validation.constraints.Null;

import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class Sprint2B5911417Test {

	@Autowired
	private EventStoreRepository eventStoreRepository;

	@Autowired
	private PlaceEventRepository placeEventRepository;


	@Autowired
	private StoreTypeRepository storeTypeRepository;

	@Autowired
	private com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;

    @Autowired
    com.se.team21.backend.B5901890.Repository.RegisterStaffRepository staffRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
    }
    
    @Test
	public void testEventStoreSuccess() {
		EventStore eventStore = new EventStore();
		eventStore.setStoreName("KFC");
		eventStore.setStoreTel("0123456789");
		eventStore.setOctime("8-11");
		eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
		eventStore.setStaffFStore(staffRepository.getOne(1L));
		eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));

		try {
			entityManager.persist(eventStore);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}
		System.out.println("Test1 testEventStoreSuccess ==============");
		System.out.println("================= testEventStoreSuccess");
		}
		
		@Test
		public void testStoreNameMustNotBeNull() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName(null);
			eventStore.setStoreTel("0123456789");
			eventStore.setOctime("8-11");
			eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore.setStaffFStore(staffRepository.getOne(1L));
			eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));
	
			try {
				entityManager.persist(eventStore);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test2 testStoreNameMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test2 testStoreNameMustNotBeNull");
			}
		}

		@Test
    public void testStoreTelMustBeDigit() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName("KFC");
			eventStore.setStoreTel("ABCDEFGHIJ");
			eventStore.setOctime("8-11");
			eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore.setStaffFStore(staffRepository.getOne(1L));
			eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));
	
        try {
            entityManager.persist(eventStore);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test3 testStoreTelMustNotBeDigit ==============");
            System.out.println(e);
            System.out.println("================= Test3 testStoreTelMustNotBeDigit");
        }
		}
		
		@Test
    public void testStoreTelMustNotOverThan10() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName("KFC");
			eventStore.setStoreTel("01234567890");
			eventStore.setOctime("8-11");
			eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore.setStaffFStore(staffRepository.getOne(1L));
			eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));

        try {
            entityManager.persist(eventStore);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test4 testStoreTelMustNotOverThan10 ==============");
            System.out.println(e);
            System.out.println("================= Test4 testStoreTelMustNotOverThan10");
        }
		}
		
	
		
		@Test
    public void testStoreTelMustNotLessThan10() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName("KFC");
			eventStore.setStoreTel("01234");
			eventStore.setOctime("8-11");
			eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore.setStaffFStore(staffRepository.getOne(1L));
			eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));
        try {
            entityManager.persist(eventStore);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test5 testStoreTelMustNotOverThan10 ==============");
            System.out.println(e);
            System.out.println("================= Test5 testStoreTelMustNotOverThan10");
        }
		}

		@Test
    public void teststoreTelMustBeUnique() {
			EventStore eventStore1 = new EventStore();
			eventStore1.setStoreName("KFC");
			eventStore1.setStoreTel("0123456789");
			eventStore1.setOctime("8-11");
			eventStore1.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore1.setStaffFStore(staffRepository.getOne(1L));
			eventStore1.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));

        entityManager.persist(eventStore1);
        entityManager.flush();

        EventStore eventStore2 = new EventStore();
			eventStore2.setStoreName("MK");
			eventStore2.setStoreTel("0123456789");
			eventStore2.setOctime("8-11");
			eventStore2.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore2.setStaffFStore(staffRepository.getOne(1L));
			eventStore2.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));

        try {
            entityManager.persist(eventStore2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("Test6 teststoreTelMustBeUnique ===========");
            System.out.println(e);
            System.out.println("==============Test6 teststoreTelMustBeUnique");
        }
		}
		
		@Test
		public void testoctimeMustNotBeNull() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName("KFC");
			eventStore.setStoreTel("0123456789");
			eventStore.setOctime(null);
			eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore.setStaffFStore(staffRepository.getOne(1L));
			eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));
			try {
				entityManager.persist(eventStore);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test7 testoctimeMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test7 testoctimeMustNotBeNull");
			}
		}
		
		@Test
		public void testsportEventFStoreMustNotBeNull() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName("KFC");
			eventStore.setStoreTel("0123456789");
			eventStore.setOctime("8-11");
			eventStore.setSportEventFStore(null);
			eventStore.setStaffFStore(staffRepository.getOne(1L));
			eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));
			try {
				entityManager.persist(eventStore);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test8 testsportEventFStoreMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test8 testsportEventFStoreMustNotBeNull");
			}
		}

		@Test
		public void testStaffFStoreMustNotBeNull() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName("KFC");
			eventStore.setStoreTel("0123456789");
			eventStore.setOctime("8-11");
			eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore.setStaffFStore(null);
			eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(1L));
			try {
				entityManager.persist(eventStore);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test9 testStaffFStoreMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test9 testStaffFStoreMustNotBeNull");
			}
		}

		@Test
		public void testsetTypeStoreFStoreMustNotBeNull() {
			EventStore eventStore = new EventStore();
			eventStore.setStoreName("KFC");
			eventStore.setStoreTel("0123456789");
			eventStore.setOctime("8-11");
			eventStore.setSportEventFStore(sportsEventRepository.getOne(1L));
			eventStore.setStaffFStore(staffRepository.getOne(1L));
			eventStore.setSetTypeStoreFStore(null);
			try {
				entityManager.persist(eventStore);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test10 testsetTypeStoreFStoreMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test10 testsetTypeStoreFStoreMustNotBeNull");
			}
		}

		@Test
		public void testTypeNameSuccess() {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName("Ballstadium");
			placeEvent.setPlaceAddress("nakornratchasrima");
			placeEvent.setPlaceTel("0123456789");
	
			try {
				entityManager.persist(placeEvent);
				entityManager.flush();
	
			} catch(javax.validation.ConstraintViolationException e) {
				fail("Should not pass to this line");
			}
			System.out.println("Test14 testTypeNameSuccess ==============");
			System.out.println("================= testTypeNameSuccess");
			}

			

			

		@Test
		public void testtypeNameMustNotBeNull() {
			StoreType storeType = new StoreType();
			storeType.setTypeName(null);
			
			try {
				entityManager.persist(storeType);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test11 testtypeNameMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test11 testtypeNameMustNotBeNull");
			}
		}

		@Test
    public void testPlaceTelMustBeDigit() {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName("Ballstadium");
			placeEvent.setPlaceAddress("nakornratchasrima");
			placeEvent.setPlaceTel("ABCDEFGHIJ");
	
        try {
            entityManager.persist(placeEvent);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test12 testPlaceTelMustBeDigit ==============");
            System.out.println(e);
            System.out.println("================= Test12 testPlaceTelMustBeDigit");
        }
		}

		@Test
		public void testPlaceNameSuccess() {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName("Ballstadium");
			placeEvent.setPlaceAddress("nakornratchasrima");
			placeEvent.setPlaceTel("0123456789");
	
			try {
				entityManager.persist(placeEvent);
				entityManager.flush();
	
			} catch(javax.validation.ConstraintViolationException e) {
				fail("Should not pass to this line");
			}
			System.out.println("Test15 testPlaceNameSuccess ==============");
			System.out.println("================= testPlaceNameSuccess");
			}

		@Test
    public void testPlaceNameMustBeUnique() {
			PlaceEvent placeEvent1 = new PlaceEvent();
			placeEvent1.setPlaceName("Ballstadium");
			placeEvent1.setPlaceAddress("nakornratchasrima");
			placeEvent1.setPlaceTel("0123456789");

        entityManager.persist(placeEvent1);
        entityManager.flush();

        PlaceEvent placeEvent2 = new PlaceEvent();
			placeEvent2.setPlaceName("Ballstadium");
			placeEvent2.setPlaceAddress("phitsanuloke");
			placeEvent2.setPlaceTel("9876543210");
        try {
            entityManager.persist(placeEvent2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("Test13 testPlaceNameMustBeUnique ===========");
            System.out.println(e);
            System.out.println("==============Test13 testPlaceNameMustBeUnique");
        }
		}

		@Test 
		public void testPlaceAddressMustNotBeNull() {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName("Ballstadium");
			placeEvent.setPlaceAddress(null);
			placeEvent.setPlaceTel("0123456789");
	
			try {
				entityManager.persist(placeEvent);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test16 testPlaceAddressMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test16 testPlaceAddressMustNotBeNull");
			}
		}

		@Test
		public void testPlaceTelMustNotOverThan10() {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName("Ballstadium");
			placeEvent.setPlaceAddress("phitsanuloke");
			placeEvent.setPlaceTel("01234567890123");

        try {
            entityManager.persist(placeEvent);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test17 testPlaceTelMustNotOverThan10 ==============");
            System.out.println(e);
            System.out.println("================= Test17 testPlaceTelMustNotOverThan10");
        }
		}
		
	
		
		@Test
    public void testPlaceTelMustNotLessThan10() {
			PlaceEvent placeEvent = new PlaceEvent();
			placeEvent.setPlaceName("Ballstadium");
			placeEvent.setPlaceAddress("phitsanuloke");
			placeEvent.setPlaceTel("01234");
        try {
            entityManager.persist(placeEvent);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test18 testPlaceTelMustNotLessThan10 ==============");
            System.out.println(e);
            System.out.println("================= Test18 testPlaceTelMustNotLessThan10");
        }
		}

		@Test 
		public void testSdateMustNotBeNull() {
			ReservePlace reservePlace = new ReservePlace();
			reservePlace.setSdate(null);
			reservePlace.setEdate(new Date(100,2,15));
			reservePlace.setPlaceEventF(placeEventRepository.getOne(1L));
			reservePlace.setSportEventF(sportsEventRepository.getOne(1L));
			reservePlace.setStaffF(staffRepository.getOne(1L));
	
			try {
				entityManager.persist(reservePlace);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test19 testSdateMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test19 testSdateMustNotBeNull");
			}
		}

		@Test 
		public void testEdateMustNotBeNull() {
			ReservePlace reservePlace = new ReservePlace();
			reservePlace.setSdate(new Date(100,2,15));
			reservePlace.setEdate(null);
			reservePlace.setPlaceEventF(placeEventRepository.getOne(1L));
			reservePlace.setSportEventF(sportsEventRepository.getOne(1L));
			reservePlace.setStaffF(staffRepository.getOne(1L));
	
			try {
				entityManager.persist(reservePlace);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test20 testEdateMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test20 testEdateMustNotBeNull");
			}
		}

		@Test 
		public void testPlaceEventFMustNotBeNull() {
			ReservePlace reservePlace = new ReservePlace();
			reservePlace.setSdate(new Date(100,2,15));
			reservePlace.setEdate(new Date(101,2,16));
			reservePlace.setPlaceEventF(null);
			reservePlace.setSportEventF(sportsEventRepository.getOne(1L));
			reservePlace.setStaffF(staffRepository.getOne(1L));
	
			try {
				entityManager.persist(reservePlace);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test21 testPlaceEventFMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test21 testPlaceEventFMustNotBeNull");
			}
		}

		@Test 
		public void testSportEventFMustNotBeNull() {
			ReservePlace reservePlace = new ReservePlace();
			reservePlace.setSdate(new Date(100,2,15));
			reservePlace.setEdate(new Date(101,2,16));
			reservePlace.setPlaceEventF(placeEventRepository.getOne(1L));
			reservePlace.setSportEventF(null);
			reservePlace.setStaffF(staffRepository.getOne(1L));
	
			try {
				entityManager.persist(reservePlace);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test22 testSportEventFMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test22 testSportEventFMustNotBeNull");
		}
	}

	@Test 
		public void testStaffFMustNotBeNull() {
			ReservePlace reservePlace = new ReservePlace();
			reservePlace.setSdate(new Date(100,2,15));
			reservePlace.setEdate(new Date(101,2,16));
			reservePlace.setPlaceEventF(placeEventRepository.getOne(1L));
			reservePlace.setSportEventF(sportsEventRepository.getOne(1L));
			reservePlace.setStaffF(null);
	
			try {
				entityManager.persist(reservePlace);
				entityManager.flush();
				fail("Should not pass to this line");
			} catch(javax.validation.ConstraintViolationException e) {
				Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
				assertEquals(violations.isEmpty(), false);
				assertEquals(violations.size(), 1);
				System.out.println("Test23 testStaffFMustNotBeNull ==============");
				System.out.println(e);
				System.out.println("================= Test23 testStaffFMustNotBeNull");
		}
	}

}