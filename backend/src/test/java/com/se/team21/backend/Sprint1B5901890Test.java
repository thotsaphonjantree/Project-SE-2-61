package com.se.team21.backend;
import com.se.team21.backend.B5901890.Entity.*;
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

import com.se.team21.backend.B5901890.Repository.GenderStaffRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
@DataJpaTest
public class Sprint1B5901890Test {

    @Autowired
    RegisterStaffRepository registerStaffRepository;

    @Autowired
    GenderStaffRepository genderStaffRepository;

    @Autowired
    AgeStaffRepository ageStaffRepository;

    @Autowired
    WorkStaffRepository workStaffRepository;

    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();}

    @Test
    public void testInsertDataFull() {
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity.setTell("012345678");
        resultEntity.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity.setWorkStaff(workStaffRepository.getOne(1L));
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
    public void testInsertDataNull() {
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff(null);
        resultEntity.setTell("012345678");
        resultEntity.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity.setWorkStaff(workStaffRepository.getOne(1L));
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
            System.out.println("Test NUll" + e.getMessage());
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
        RegisterStaff resultEntity1 = new RegisterStaff();
        resultEntity1.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity1.setTell("012345678");
        resultEntity1.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity1.setWorkStaff(workStaffRepository.getOne(1L));
        resultEntity1.setGenderStaff(genderStaffRepository.getOne(1L));
        entityManager.persist(resultEntity1);
        entityManager.flush();

        RegisterStaff resultEntity2 = new RegisterStaff();
        resultEntity2.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity2.setTell("012345679");
        resultEntity1.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity1.setWorkStaff(workStaffRepository.getOne(1L));
        resultEntity1.setGenderStaff(genderStaffRepository.getOne(1L));
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
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity.setTell("01234567--");
        resultEntity.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity.setWorkStaff(workStaffRepository.getOne(1L));
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
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff("Mr.Pattaraphong Aonta");
        resultEntity.setTell("1");
        resultEntity.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity.setWorkStaff(workStaffRepository.getOne(1L));
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
    public void testResultNameCannotMax10() {
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity.setTell("01234567855555555555555");
        resultEntity.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity.setWorkStaff(workStaffRepository.getOne(1L));
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
    public void testInsertDatanullage() {
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity.setTell("012345678");
        resultEntity.setAgeStaff(null);
        resultEntity.setWorkStaff(workStaffRepository.getOne(1L));
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
            System.out.println("Error Age Null" + e.getMessage());
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

    @Test
    public void testInsertDatanullwork() {
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity.setTell("012345678");
        resultEntity.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity.setWorkStaff(null);
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
    public void testInsertDatanullGender() {
        RegisterStaff resultEntity = new RegisterStaff();
        resultEntity.setNameRegisterStaff("Pattaraphong Aonta");
        resultEntity.setTell("012345678");
        resultEntity.setAgeStaff(ageStaffRepository.getOne(1L));
        resultEntity.setWorkStaff(workStaffRepository.getOne(1L));
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
            System.out.println("Error Gender null" + e.getMessage());
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            System.out.println("####################################################################");
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
        }
    }

}
