package com.se.team21.backend;


import com.se.team21.backend.B5926329.Entity.Event;
import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Entity.PayCategory;
import com.se.team21.backend.B5926329.Entity.Payment;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Repository.PayCategoryRepository;

import com.se.team21.backend.B5926329.Sprint2.Repository.JoinEventMemberRepository;
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
import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class Sprint1B5926329Test {

    @Autowired
    private JoinEventMemberRepository joinEventMemberRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;

    @Autowired
    private PayCategoryRepository payCategoryRepository;


    @Autowired
    private TestEntityManager entityManager;

    private Validator validator;

    @Before
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testPaymentSuccess() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(2000L);
        payment.setPaymentDate(new Timestamp(date.getTime()));
        payment.setNameOnCard("Charle");
        payment.setJoinEventMember(joinEventMemberRepository.getOne(1L));
        payment.setMembers(memberRepository.getOne(1L));
        payment.setPayCategory(payCategoryRepository.getOne(1L));

        try {
            entityManager.persist(payment);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
        System.out.println("Test01 Success ==============");
        System.out.println("================= Test01 Success");
    }

    @Test
    public void testPaymentPaidMustNotBeNull() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(null);
        payment.setPaymentDate(new Timestamp(date.getTime()));
        payment.setNameOnCard("Charle");
        payment.setJoinEventMember(joinEventMemberRepository.getOne(1L));
        payment.setMembers(memberRepository.getOne(1L));
        payment.setPayCategory(payCategoryRepository.getOne(1L));

        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test02 PaymentPaidMustNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test02 PaymentPaidMustNotBeNull");
        }
    }

    @Test
    public void testPaymentDateMustNotBeNull() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(2000L);
        payment.setPaymentDate(null);
        payment.setNameOnCard("Charle");
        payment.setJoinEventMember(joinEventMemberRepository.getOne(1L));
        payment.setMembers(memberRepository.getOne(1L));
        payment.setPayCategory(payCategoryRepository.getOne(1L));

        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test03 PaymentDateMustNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test03 PaymentDateMustNotBeNull");
        }
    }

    @Test
    public void testNameOnCardMustNotBeDigit() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(2000L);
        payment.setPaymentDate(new Timestamp(date.getTime()));
        payment.setNameOnCard("Charle1234567");
        payment.setJoinEventMember(joinEventMemberRepository.getOne(1L));
        payment.setMembers(memberRepository.getOne(1L));
        payment.setPayCategory(payCategoryRepository.getOne(1L));

        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test04 NameOnCardMustNotBeDigit ==============");
            System.out.println(e);
            System.out.println("================= Test04 NameOnCardMustNotBeDigit");
        }
    }

    @Test
    public void testNameOnCardMustOverThan25() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(2000L);
        payment.setPaymentDate(new Timestamp(date.getTime()));
        payment.setNameOnCard("abcdefghijklmnopqrstuvwxyz");
        payment.setJoinEventMember(joinEventMemberRepository.getOne(1L));
        payment.setMembers(memberRepository.getOne(1L));
        payment.setPayCategory(payCategoryRepository.getOne(1L));

        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test05 testNameOnCardMustOverThan25 ==============");
            System.out.println(e);
            System.out.println("================= Test05 testNameOnCardMustOverThan25");
        }
    }

    @Test
    public void testJoinEventMemberNotBeNull() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(2000L);
        payment.setPaymentDate(new Timestamp(date.getTime()));
        payment.setNameOnCard("Charles");
        payment.setJoinEventMember(null);
        payment.setMembers(memberRepository.getOne(1L));
        payment.setPayCategory(payCategoryRepository.getOne(1L));

        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test06 testJoinEventMemberNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test06 testJoinEventMemberNotBeNull");
        }
    }

    @Test
    public void testMembersNotBeNull() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(2000L);
        payment.setPaymentDate(new Timestamp(date.getTime()));
        payment.setNameOnCard("Charles");
        payment.setJoinEventMember(joinEventMemberRepository.getOne(1L));
        payment.setMembers(null);
        payment.setPayCategory(payCategoryRepository.getOne(1L));

        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test07 testMembersNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test07 testMembersNotBeNull");
        }
    }

    @Test
    public void testPayCategoryNotBeNull() {
        Date date = new Date();
        Payment payment = new Payment();
        payment.setPaymentPaid(2000L);
        payment.setPaymentDate(new Timestamp(date.getTime()));
        payment.setNameOnCard("Charles");
        payment.setJoinEventMember(joinEventMemberRepository.getOne(1L));
        payment.setMembers(memberRepository.getOne(1L));
        payment.setPayCategory(null);

        try {
            entityManager.persist(payment);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test08 testPayCategoryNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test08 testPayCategoryNotBeNull");
        }
    }

    @Test
    public void testPayCategorySuccess() {
        PayCategory payCategory = new PayCategory();
        payCategory.setPaycateName("Mastercard");

        try {
            entityManager.persist(payCategory);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
        System.out.println("Test9 testPayCategorySuccess ==============");
        System.out.println("================= Test9 testPayCategorySuccess");
    }


    @Test
    public void testPayCategoryNameNotBeNull() {
        PayCategory payCategory = new PayCategory();
        payCategory.setPaycateName(null);
        try {
            entityManager.persist(payCategory);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test10 testPayCategoryNameNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test10 testPayCategoryNameNotBeNull");
        }
    }

    @Test
    public void testMemberSuccess() {
        Member member = new Member();
        member.setUsername("Charles");
        member.setPassword("12345678");
        member.setName("Charl");

        try {
            entityManager.persist(member);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
        System.out.println("Test11 testMemberSuccess ==============");
        System.out.println("================= Test11 testMemberSuccess");
    }



    @Test
    public void testUsernameMustBeUnique() {
        Member member = new Member();
        member.setUsername("Charles");
        member.setPassword("12345678");
        member.setName("Charl");
        entityManager.persist(member);
        entityManager.flush();

        Member member2 = new Member();
        member2.setUsername("Charles");
        member2.setPassword("87654321");
        member2.setName("David");
        try {
            entityManager.persist(member2);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.persistence.PersistenceException e) {
            System.out.println("Test12 testUsernameMustBeUnique ===========");
            System.out.println(e);
            System.out.println("==============Test12 testUsernameMustBeUnique");
        }
    }

    @Test
    public void testPasswordNotBeNull() {
        Member member = new Member();
        member.setUsername("Charles");
        member.setPassword(null);
        member.setName("Charl");
        try {
            entityManager.persist(member);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test13 testPasswordNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test13 testPasswordNotBeNull");
        }
    }

    @Test
    public void testNameNotBeNull() {
        Member member = new Member();
        member.setUsername("Charles");
        member.setPassword("12345678");
        member.setName(null);
        try {
            entityManager.persist(member);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test14 testNameNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test14 testNameNotBeNull");
        }
    }

    @Test
    public void testEventSuccess() {
        Event event = new Event();
        event.setEventName("Running 90k");
        event.setEventPrice(500L);
        try {
            entityManager.persist(event);
            entityManager.flush();

        } catch(javax.validation.ConstraintViolationException e) {
            fail("Should not pass to this line");
        }
        System.out.println("Test15 testEventSuccess ==============");
        System.out.println("================= Test15 testEventSuccess");
    }

    @Test
    public void testEventNameNotBeNull() {
        Event event = new Event();
        event.setEventName(null);
        event.setEventPrice(500L);
        try {
            entityManager.persist(event);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test16 testEventNameNotBeNull ==============");
            System.out.println(e);
            System.out.println("================= Test16 testEventNameNotBeNull");
        }
    }

    @Test
    public void testEventPriceNotNull() {
        Event event = new Event();
        event.setEventName("Running 90k");
        event.setEventPrice(null);
        try {
            entityManager.persist(event);
            entityManager.flush();
            fail("Should not pass to this line");
        } catch(javax.validation.ConstraintViolationException e) {
            Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
            assertEquals(violations.isEmpty(), false);
            assertEquals(violations.size(), 1);
            System.out.println("Test17 testEventPriceNotNull ==============");
            System.out.println(e);
            System.out.println("================= Test17 testEventPriceNotNull");
        }
    }
}

