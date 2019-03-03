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
public class RelatedInformationApplicationTest {
    @Autowired
    RelatedInformationRepository relatedInformationRepository;

    @Autowired
    com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;

    @Autowired
    AgencyTypeRepository agencyTypeRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    ProvinceRepository provinceRepository;

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
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
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
    public void testNameCannotBeNull() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName(null);
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
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
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));
        entityManager.persist(r);
        entityManager.flush();

        RelatedInformationEntity r2 = new RelatedInformationEntity();
        r2.setRelatedinformationAddress("SUT");
        r2.setRelatedinformationDate(new Date(100,2,15));
        r2.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r2.setRelatedinformationPhone("0967627350");
        r2.setRelatedinformationName("Narawich Saphimarn");
        r2.setSportsEvent(sportsEventRepository.getOne(1L));
        r2.setProvinceEntity(provinceRepository.getOne(50L));
        r2.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r2.setCountryEntity(countryRepository.getOne(1L));

        try {
            entityManager.persist(r2);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
//			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
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
//			assertEquals(violations.isEmpty(), false);
//			assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testPhonenumberCannotcharacotr() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("adaasdasdGBH------085456");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
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
    public void testPhonenumberCannotMin2() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("11");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
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
    public void testPhonenumberCannotMax30() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0123456789012345678901234567895555");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
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
    public void testEmailCannotBeNull() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail(null);
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test Email null");
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
    public void testEmailnoSymbol() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("Narawich^^^>>><<<$$$@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test Email no Symbol");
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
    public void testDatenotNull() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(null);
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test Date not Null ");
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
    public void testAddressnotNULL() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress(null);
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test Address not NULL");
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
    public void testAddressNosymbol() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("ต.ในเมื่อง SUT ถ.มหาวิทยาลัย >><><>> ^^^^^");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test Address No symbol");
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
    public void testsportNotnull() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(null);
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test sport not null");
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
    public void testprovinceNotNULL() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(null);
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test province not null");
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
    public void testagencyNotNULL() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(null);
        r.setCountryEntity(countryRepository.getOne(1L));


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test agency not null");
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
    public void testCountryNotNULL() {
        RelatedInformationEntity r = new RelatedInformationEntity();
        r.setRelatedinformationAddress("SUT");
        r.setRelatedinformationDate(new Date(100,2,15));
        r.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r.setRelatedinformationPhone("0967627350");
        r.setRelatedinformationName("Narawich Saphimarn");
        r.setSportsEvent(sportsEventRepository.getOne(1L));
        r.setProvinceEntity(provinceRepository.getOne(50L));
        r.setAgencyTypeEntity(agencyTypeRepository.getOne(1L));
        r.setCountryEntity(null);


        try {
            entityManager.persist(r);
            entityManager.flush();

            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("Test country not null");
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
