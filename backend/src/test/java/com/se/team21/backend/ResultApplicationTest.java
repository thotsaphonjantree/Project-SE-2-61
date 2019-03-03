package com.se.team21.backend;

import com.se.team21.backend.B5909711.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Collections;
import java.util.Date;
import java.util.OptionalInt;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;

import com.se.team21.backend.B5909711.Entity.RelatedInformationEntity;
import com.se.team21.backend.B5909711.Entity.ResultEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class ResultApplicationTest {
	@Autowired
	ResultRepository resultRepository;
	@Autowired
	RelatedInformationRepository relatedInformationRepository;
	@Autowired
	com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;
	@Autowired
	com.se.team21.backend.b5910311.repository.SportsTypeRepository sportsTypeRepository;
	@Autowired
	ProvinceRepository provinceRepository;
	@Autowired
	RatingRepository ratingRepository;
	@Autowired
	PersonTypeRepository personTypeRepository;

	@Autowired
	private TestEntityManager entityManager;

	private Validator validator;

	@Before
	public void setup() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testInsertDataFull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test Full data");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");

//			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testDatenotNull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(null);
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test Date null");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testResultNameCannotBeNull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName(null);
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));


		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test null");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testNameMustBeUnique() {
		ResultEntity resultEntity1 = new ResultEntity();
		resultEntity1.setResultName("Mr.Narawich Saphimarn");
		resultEntity1.setResultAddress("SUT");
		resultEntity1.setResultDate(new Date(5,2,3));
		resultEntity1.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity1.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity1.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity1.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity1.setPersonTypeEntity(personTypeRepository.getOne(1L));
		entityManager.persist(resultEntity1);
		entityManager.flush();

		ResultEntity resultEntity2 = new ResultEntity();
		resultEntity2.setResultName("Mr.Narawich Saphimarn");
		resultEntity2.setResultAddress("SUT");
		resultEntity2.setResultDate(new Date(5,2,3));
		resultEntity2.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity2.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity2.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity2.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity2.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity2);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.persistence.PersistenceException e) {
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test Unique");
			e.printStackTrace();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
		}
	}

	@Test
	public void testResultAddressCannotcharacotr() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("...;;.__.----------");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test Cannot Characotr");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testResultNameCannotMin1() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("A");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test Min");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testResultNameCannotMax20() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test Max");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testSportsEventCannotNull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(null);
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test SportsEventCannotNull");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testSportsTypeCannotNull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(null);
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test SportsTypeCannotNull");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testProvinceCannotNull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(null);
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test ProvinceCannotNull");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testRatingCannotNull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(null);
		resultEntity.setPersonTypeEntity(personTypeRepository.getOne(1L));

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test RatingCannotNull");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}

	@Test
	public void testPersonTypeCannotNull() {
		ResultEntity resultEntity = new ResultEntity();
		resultEntity.setResultName("Mr.Narawich Saphimarn");
		resultEntity.setResultAddress("SUT");
		resultEntity.setResultDate(new Date(5,2,3));
		resultEntity.setSportsEvent(sportsEventRepository.getOne(1L));
		resultEntity.setSportsType(sportsTypeRepository.getOne(1L));
		resultEntity.setProvinceEntity(provinceRepository.getOne(50L));
		resultEntity.setRatingEntity(ratingRepository.getOne(1L));
		resultEntity.setPersonTypeEntity(null);

		try {
			entityManager.persist(resultEntity);
			entityManager.flush();

			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("Test PersonTypeCannotNull");
			System.out.println("Error" + e.getMessage());
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			System.out.println("####################################################################");
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
		}
	}
}

