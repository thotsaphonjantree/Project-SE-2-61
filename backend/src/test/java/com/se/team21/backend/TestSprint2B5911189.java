package com.se.team21.backend;

import com.se.team21.backend.B5911189.Entity.*;
import com.se.team21.backend.B5911189.Repository.*;
import com.se.team21.backend.b5910311.entity.SportsEvent;
import com.se.team21.backend.b5910311.repository.SportsEventRepository;

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
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class TestSprint2B5911189 {

    @Autowired private SponsorRegisRepository sponsorRegisRepository;
    @Autowired private SponsorStatusRepository sponsorStatusRepository;
    @Autowired private TransferRepository transferRepository;

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

            SponsorRegis sponsor = new SponsorRegis();
            sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
            sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
            sponsor.setAddress("352 หมู่ 6");
            sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
            sponsor.setAmount("54321");
            sponsor.setPhonenumber("0852519442");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();

        } catch (javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }


    }

    @Test
    public void testNamesponsorNotBeNULL() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis(null);
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber("0852519442");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test1 NameSponsorRegis Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test1 NameSponsorRegis Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testSponsorStatusNotBeNULL() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus(null));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber("0852519442");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test2 SponsorStatus Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test2 SponsorStatus Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testAddressNotBeNULL() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress(null);
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber("0852519442");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test3 Address Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test3 Address Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testTransferNotBeNULL() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer(null));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber("0852519442");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test4 Transfer Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test4 Transfer Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testAmountNotBeNULL() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount(null);
        sponsor.setPhonenumber("0852519442");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test5 Amount Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test5 Amount Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testPhonenumberNotBeNULL() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber(null);


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test6 Phonenumber Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test6 Phonenumber Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testPhonenumberNotBeABC() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber("ABC1234567");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test7 Phonenumber Not be ABC ==============");
            System.out.println(e);
            System.out.println("================= Test7 Phonenumber Not be ABC");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testPhonenumberless9() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber("01234567");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test8 Phonenumber less9 ==============");
            System.out.println(e);
            System.out.println("================= Test8 Phonenumber less9");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testPhonenumberover10() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("54321");
        sponsor.setPhonenumber("0123456789111");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test9 Phonenumber over10 ==============");
            System.out.println(e);
            System.out.println("================= Test9 Phonenumber over10");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testAmountLess2() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("1");
        sponsor.setPhonenumber("0123456789");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test10 AmountLess2 ==============");
            System.out.println(e);
            System.out.println("================= Test10 AmountLess2");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testAmountOver10() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("10000000001");
        sponsor.setPhonenumber("0123456789");


        try {
            entityManager.persist(sponsor);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test11 AmountOver10 ==============");
            System.out.println(e);
            System.out.println("================= Test11 AmountOver10");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
    @Test
    public void testNameSponsorRegisNotEqul() {

        SponsorRegis sponsor = new SponsorRegis();
        sponsor.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ร้านค้า"));
        sponsor.setAddress("352 หมู่ 6");
        sponsor.setTransfer(transferRepository.findBynameTransfer("เงินสด"));
        sponsor.setAmount("10051");
        sponsor.setPhonenumber("0123456789");
        entityManager.persist(sponsor);
        entityManager.flush();

        SponsorRegis sponsor2= new SponsorRegis();
        sponsor2.setNameSponsorRegis("ยงศิลป์ ช่อจำปา");
        sponsor2.setSponsorStatus(sponsorStatusRepository.findBynameStatus("ห้างหุ้นส่วนจำกัด"));
        sponsor2.setAddress("352 หมู่ 9");
        sponsor2.setTransfer(transferRepository.findBynameTransfer("เช็คเงินสด"));
        sponsor2.setAmount("1000");
        sponsor2.setPhonenumber("0135456789");

        try {
            entityManager.persist(sponsor2);
            entityManager.flush();
        }
        catch(javax.persistence.PersistenceException e){
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test10 Unique ===========");
            System.out.println(e.getStackTrace());
            System.out.println("==============Test10 Unique");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }



}