package com.se.team21.backend;
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
import com.se.team21.backend.B5909711.Repository.RelatedInformationRepository;
import com.se.team21.backend.B5909711.Entity.ResultEntity;
import com.se.team21.backend.B5909711.Repository.ResultRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class RelatedInformationApplicationTest {
    @Autowired
    ResultRepository resultRepository;

    @Autowired
    RelatedInformationRepository relatedInformationRepository;

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
        entityManager.persist(r);
        entityManager.flush();

        RelatedInformationEntity r2 = new RelatedInformationEntity();
        r2.setRelatedinformationAddress("SUT");
        r2.setRelatedinformationDate(new Date(100,2,15));
        r2.setRelatedinformationEmail("NarawichSaphimarn@gmail.com");
        r2.setRelatedinformationPhone("0967627350");
        r2.setRelatedinformationName("Narawich Saphimarn");

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
}
