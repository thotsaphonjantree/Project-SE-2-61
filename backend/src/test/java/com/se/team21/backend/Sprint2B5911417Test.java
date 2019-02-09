package com.se.team21.backend;

import com.se.team21.backend.AnanB5911417.sp2.Repository.*;
import com.se.team21.backend.AnanB5911417.sp2.Entity.*;
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
	public void testSuccess() {
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
		System.out.println("Test1 Success ==============");
		System.out.println("================= Success");
    }

    

}