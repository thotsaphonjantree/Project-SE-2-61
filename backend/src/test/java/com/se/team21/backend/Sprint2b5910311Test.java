package com.se.team21.backend;

import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
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
public class Sprint2b5910311Test {

	@Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

    @Test
	public void testProfileSuccess() {
        Profile profile = new Profile();
		profile.setFirstName("Thaweechai");
		profile.setLastName("Kanklang");
        profile.setAddressname(addressRepository.getOne(3L));
		profile.setName(memberRepository.getOne(2L));

		try {
			entityManager.persist(profile);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}

	}

	@Test
	public void testFirstNameNotBeNull() {
		Profile profile = new Profile();
		profile.setFirstName(null);
		profile.setLastName("Kanklang");
        profile.setAddressname(addressRepository.getOne(3L));
		profile.setName(memberRepository.getOne(2L));
		try {
			entityManager.persist(profile);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test1 testFirstNameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test1 testFirstNameNotBeNull");
		}
	}

    @Test
	public void testLastNameNotBeNull() {
		Profile profile = new Profile();
		profile.setFirstName("Thaweechai");
		profile.setLastName(null);
        profile.setAddressname(addressRepository.getOne(3L));
		profile.setName(memberRepository.getOne(2L));
		try {
			entityManager.persist(profile);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test2 testLastNameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test2 testLastNameNotBeNull");
		}
	}

    @Test
	public void testNameNotBeNull() {
		Profile profile = new Profile();
		profile.setFirstName("Thaweechai");
		profile.setLastName("Kanklang");
        profile.setAddressname(addressRepository.getOne(3L));
		profile.setName(null);
		try {
			entityManager.persist(profile);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test3 testNameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test3 testNameNotBeNull");
		}
	}

    @Test
	public void testAddressNotBeNull() {
		Profile profile = new Profile();
		profile.setFirstName("Thaweechai");
		profile.setLastName("Kanklang");
        profile.setAddressname(null);
		profile.setName(memberRepository.getOne(2L));
		try {
			entityManager.persist(profile);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test4 testAddressNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test4 testAddressNotBeNull");
		}
	}
    
    @Test
	public void testAddressSuccess() {
		Address address = new Address();
		address.setAddressname("Nakhonratchasima");
		address.setCode("15915");
		try {
			entityManager.persist(address);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}
	}

    @Test
	public void testAddressnameNotBeNull() {
		Address address = new Address();
		address.setAddressname(null);
		address.setCode("30000");
		try {
			entityManager.persist(address);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test5 testAddressnameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test5 testAddressnameNotBeNull");
		}
	}

    @Test
	public void testCodeNotBeNull() {
		Address address = new Address();
		address.setAddressname("Nakhonratchasima");
		address.setCode(null);
		try {
			entityManager.persist(address);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test6 testCodeNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test6 testCodeNotBeNull");
		}
	}

    @Test
	public void testCodeOverThan5() {
		Address address = new Address();
		address.setAddressname("Nakhonratchasima");
		address.setCode("123456");
		try {
			entityManager.persist(address);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test7 testCodeOverThan5 ==============");
			System.out.println(e);
			System.out.println("================= Test7 testCodeOverThan5");
		}
	}

    @Test
	public void testCodeLessThan5() {
		Address address = new Address();
		address.setAddressname("Nakhonratchasima");
		address.setCode("1234");
		try {
			entityManager.persist(address);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test2 testCodeLessThan8 ==============");
			System.out.println(e);
			System.out.println("================= Test8 testCodeLessThan5");
		}
	}

    @Test
	public void testCodeMustBeNumber() {
		Address address = new Address();
		address.setAddressname("Nakhonratchasima");
		address.setCode("ASDFG");
		try {
			entityManager.persist(address);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test9 testCodeMustBeNumber ==============");
			System.out.println(e);
			System.out.println("================Test9 testCodeMustBeNumber");
		}
	}
    
    @Test
	public void testCodeMustBeUnique() {
		Address address1 = new Address();
		address1.setAddressname("Nakhonratchasima");
		address1.setCode("12345");
        entityManager.persist(address1);
		entityManager.flush();

        Address address2 = new Address();
		address2.setAddressname("Bangkok");
		address2.setCode("12345");

		try {
			entityManager.persist(address2);
			entityManager.flush();
		}
		catch(javax.persistence.PersistenceException e){
			System.out.println("Test10 testCodeMustBeUnique ===========");
			System.out.println(e);
			System.out.println("==============Test10 testCodeMustBeUnique");
		}
	}

}