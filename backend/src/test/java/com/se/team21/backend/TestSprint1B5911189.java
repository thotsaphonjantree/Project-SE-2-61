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
public class TestSprint1B5911189 {

    @Autowired private AccountRecordRepository accountrecordrepo ;
    @Autowired private IncomeExpensesRepository incomeExpensesRepository;
    @Autowired private BankRepository   bankRepository;
    @Autowired private FromToRepository fromToRepository;
    @Autowired private SportsEventRepository sportsEventRepository;

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

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("50000");

        try {
            entityManager.persist(accountRecord);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }

    }
    @Test
    public void testDateNotBeNull() {
        Date date = new Date();
        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(null);
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("12345");


        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test1 Date Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test1 Date Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }
@Test
public void testIncomeNotBeNull() {

    AccountRecord accountRecord = new AccountRecord();
    accountRecord.setSavedate(new Date(1990, 2, 1));
    accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses(null));
    accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
    accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
    accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
    accountRecord.setTitle("รับเงิน");
    accountRecord.setAmount("54321");


    try {
        entityManager.persist(accountRecord);
        entityManager.flush();
        fail("Should not pass to this line");
    } catch(javax.validation.ConstraintViolationException e) {
        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
        assertEquals(violations.isEmpty(), false);
        assertEquals(violations.size(), 1);
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("Test2 IncomeExpenses Not be Null ==============");
        System.out.println(e);
        System.out.println("================= Test2 IncomeExpenses Not be Null");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
        System.out.println("==========================================================");
    }
}
    @Test
    public void testBankNotBeNull() {

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank(null));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("54321");


        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test3 Banks Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test3 Banks Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testFromToNotBeNull() {

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo(null));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("54321");


        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test4 FromTo Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test4 FromTo Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testSportsEventNotBeNull() {

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname(null));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("54321");


        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test5 FromTo Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test5 FromTo Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }




    @Test
    public void testAmountNotBeNull() {

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount(null);


        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test6 Amount Not be Null ==============");
            System.out.println(e);
            System.out.println("================= Test6 Amount Not be Null");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testAmountOverThan10() {

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("1234567890112");

        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test7 Amount Over8 =============");
            System.out.println(e);
            System.out.println("============ Test7 Amount Over8 ");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testAmountLess2() {

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("1");

        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test8 Amount less2 ############");
            System.out.println(e);
            System.out.println("###########Test8 Amount less2 ");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testAmountNotNumber() {

        AccountRecord accountRecord = new AccountRecord();
        accountRecord.setSavedate(new Date(1990, 2, 1));
        accountRecord.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord.setTitle("รับเงิน");
        accountRecord.setAmount("ABC");

        try {
            entityManager.persist(accountRecord);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("Test9 Amount NotNumber =============");
            System.out.println(e);
            System.out.println("============ Test9 Amount NotNumber");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("==========================================================");
        }
    }

    @Test
    public void testPersonalIdMustBeUnique() {

        AccountRecord accountRecord1 = new AccountRecord();
        accountRecord1.setSavedate(new Date(1990, 2, 5));
        accountRecord1.setTitle("รับเงินนาย A");
        accountRecord1.setAmount("50000");
        accountRecord1.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord1.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));
        accountRecord1.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord1.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        entityManager.persist(accountRecord1);
        entityManager.flush();


        AccountRecord accountRecord2 = new AccountRecord();
        accountRecord2.setSavedate(new Date(1990, 2, 1));
        accountRecord2.setTitle("รับเงินนาย A");
        accountRecord2.setAmount("10000");
        accountRecord2.setIncomeExpenses(incomeExpensesRepository.findByIncomeExpenses("รายรับ"));
        accountRecord2.setSportsEvent(sportsEventRepository.findByEventname("Bike For Mom"));
        accountRecord2.setFromto(fromToRepository.findBynameFromTo("บุคคลทั่วไป"));
        accountRecord2.setBanks(bankRepository.findBynameBank("ธนาคารกรุงเทพ"));

        try {
            entityManager.persist(accountRecord2);
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

