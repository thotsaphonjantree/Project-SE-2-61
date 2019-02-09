package com.se.team21.backend;
import com.se.team21.backend.B5901890.Repository.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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

import com.se.team21.backend.B5901890.Entity.RegisterMedia;
import com.se.team21.backend.B5901890.Repository.GenderStaffRepository;
import com.se.team21.backend.B5901890.Entity.GenderStaff;
import com.se.team21.backend.B5901890.Entity.KindSportMedia;
import com.se.team21.backend.B5901890.Entity.KindMedia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Sprint2B5901890Test {

    @Autowired
    RegisterMediaRepository registerMediaRepository;

    @Autowired
    KindMediaRepository kindMediaRepository;

    @Autowired
    KindSportMediaRepository kindSportMediaRepository;

    @Autowired
    GenderStaffRepository genderStaffRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;



    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();}


    @Test
    public void testInsertDataFull() {
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media("Pattaraphong Aonta");
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("012345678");
        resultEntity.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity.setGenderStaff(genderStaffRepository.getOne(1L));
        try {
            entityManager.persist(resultEntity);
            entityManager.flush();

//			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
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
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media(null);
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("012345678");
        resultEntity.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity.setGenderStaff(genderStaffRepository.getOne(1L));


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
        RegisterMedia resultEntity1 = new RegisterMedia();
        resultEntity1.setName_Media("Pattaraphong Aonta");
        resultEntity1.setName_Company_Media("SUT");
        resultEntity1.setTel("012345678");
        resultEntity1.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity1.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity1.setGenderStaff(genderStaffRepository.getOne(1L));
        entityManager.persist(resultEntity1);
        entityManager.flush();

        RegisterMedia resultEntity2 = new RegisterMedia();
        resultEntity2.setName_Media("Pattaraphong Aonta");
        resultEntity2.setName_Company_Media("SUT");
        resultEntity2.setTel("012345679");
        resultEntity2.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity2.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity2.setGenderStaff(genderStaffRepository.getOne(1L));
//		entityManager.persist(resultEntity2);
//		entityManager.flush();
//
//		fail("Should not pass to this line");
        try {
            entityManager.persist(resultEntity2);
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
    public void testResultAddressCannotcharacotr() {
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media("Pattaraphong Aonta");
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("01234567--");
        resultEntity.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity.setGenderStaff(genderStaffRepository.getOne(1L));

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
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media("Mr.Pattaraphong Aonta");
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("1");
        resultEntity.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity.setGenderStaff(genderStaffRepository.getOne(1L));

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
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media("Pattaraphong Aonta");
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("01234567855555555555555");
        resultEntity.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity.setGenderStaff(genderStaffRepository.getOne(1L));

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
    public void testInsertDatanullmedia() {
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media("Pattaraphong Aonta");
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("012345678");
        resultEntity.setKindMedia(null);
        resultEntity.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity.setGenderStaff(genderStaffRepository.getOne(1L));

        try {
            entityManager.persist(resultEntity);
            entityManager.flush();

//			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
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
    public void testInsertDatanullSprot() {
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media("Pattaraphong Aonta");
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("012345678");
        resultEntity.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity.setKindSportMedia(null);
        resultEntity.setGenderStaff(genderStaffRepository.getOne(1L));

        try {
            entityManager.persist(resultEntity);
            entityManager.flush();

//			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
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
    public void testInsertDatanullgender() {
        RegisterMedia resultEntity = new RegisterMedia();
        resultEntity.setName_Media("Pattaraphong Aonta");
        resultEntity.setName_Company_Media("SUT");
        resultEntity.setTel("012345678");
        resultEntity.setKindMedia(kindMediaRepository.getOne(1L));
        resultEntity.setKindSportMedia(kindSportMediaRepository.getOne(1L));
        resultEntity.setGenderStaff(null);

        try {
            entityManager.persist(resultEntity);
            entityManager.flush();

//			fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
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
