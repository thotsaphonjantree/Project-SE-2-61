package com.se.team21.backend;

import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Sprint2.Entity.ExpertLevel;
import com.se.team21.backend.B5926329.Sprint2.Entity.JoinEventMember;
import com.se.team21.backend.B5926329.Sprint2.Repository.ExpertLevelRepository;
import com.se.team21.backend.B5926329.Sprint2.Repository.JoinEventMemberRepository;
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
public class Sprint2B5926329Test {

	@Autowired
	private JoinEventMemberRepository joinEventMemberRepository;

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;

	@Autowired
	private ExpertLevelRepository expertLevelRepository;

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

		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName("David");
		joinEventMember.setTelNum("0123456789");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(memberRepository.getOne(2L));
		joinEventMember.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));

		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();

		} catch(javax.validation.ConstraintViolationException e) {
			fail("Should not pass to this line");
		}
		System.out.println("Test1 Success ==============");
		System.out.println("================= Success");
	}





	@Test
	public void testTagNameNotBeNull() {
		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName(null);
		joinEventMember.setTelNum("0123456789");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(memberRepository.getOne(2L));
		joinEventMember.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));
		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test2 testTagNameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test2 testTagNameNotBeNull");
		}
	}

	@Test
	public void testTelNumOverThan10() {
		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName("David");
		joinEventMember.setTelNum("0123456789123456");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(memberRepository.getOne(2L));
		joinEventMember.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));
		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test3 TelNumOver10 =============");
			System.out.println(e);
			System.out.println("============ Test3 TelNumOver10 ");
		}
	}

	@Test
	public void testTelNumLessThan10() {
		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName("David");
		joinEventMember.setTelNum("01234");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(memberRepository.getOne(2L));
		joinEventMember.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));
		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test4 TelNumLess10 ==========");
			System.out.println(e);
			System.out.println("==============Test4 TelNumLess10");
		}
	}

	@Test
	public void testTelNumMustBeNumber() {
		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName("David");
		joinEventMember.setTelNum("ABCDEFGHJK");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(memberRepository.getOne(2L));
		joinEventMember.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));
		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test5 TelNumMustBeNumber ==============");
			System.out.println(e);
			System.out.println("================Test5 TelNumMustBeNumber");
		}
	}


	@Test
	public void testPersonalIdMustBeUnique() {

		JoinEventMember joinEventMember1 = new JoinEventMember();
		joinEventMember1.setTagName("David");
		joinEventMember1.setTelNum("0123456789");
		joinEventMember1.setPersonalId("1349900828068");
		joinEventMember1.setMembers(memberRepository.getOne(2L));
		joinEventMember1.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember1.setExpertLevels(expertLevelRepository.getOne(1L));
		entityManager.persist(joinEventMember1);
		entityManager.flush();


		JoinEventMember joinEventMember2 = new JoinEventMember();
		joinEventMember2.setTagName("Micheal");
		joinEventMember2.setTelNum("9876543210");
		joinEventMember2.setPersonalId("1349900828068");
		joinEventMember2.setMembers(memberRepository.getOne(1L));
		joinEventMember2.setSportEvent(sportsEventRepository.getOne(2L));
		joinEventMember2.setExpertLevels(expertLevelRepository.getOne(2L));

		try {
			entityManager.persist(joinEventMember2);
			entityManager.flush();
		}
		catch(javax.persistence.PersistenceException e){
			System.out.println("Test6 PersonalIdMustBeUnique ===========");
			System.out.println(e);
			System.out.println("==============Test6 PersonalIdMustBeUnique");
		}


	}

	@Test
	public void testSportIdMustBeNotNull() {
		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName("David");
		joinEventMember.setTelNum("0123456789");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(memberRepository.getOne(2L));
		joinEventMember.setSportEvent(null);
		joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));
		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test7 sportId Not be Null ==============");
			System.out.println(e);
			System.out.println("================= Test7 sportId Not be Null");
		}
	}

	@Test
	public void testMemberIdMustBeNotNull() {
		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName("David");
		joinEventMember.setTelNum("0123456789");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(null);
		joinEventMember.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember.setExpertLevels(expertLevelRepository.getOne(1L));
		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test8 memberId Not be Null ==============");
			System.out.println(e);
			System.out.println("================= Test8 memberId Not be Null");
		}
	}

	@Test
	public void testExpertLevelIdMustBeNotNull() {
		JoinEventMember joinEventMember = new JoinEventMember();
		joinEventMember.setTagName("David");
		joinEventMember.setTelNum("0123456789");
		joinEventMember.setPersonalId("1349900828068");
		joinEventMember.setMembers(memberRepository.getOne(2L));
		joinEventMember.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember.setExpertLevels(null);
		try {
			entityManager.persist(joinEventMember);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test9 memberId Not be Null ==============");
			System.out.println(e);
			System.out.println("================= Test9 memberId Not be Null");
		}
	}


	@Test
	public void testMembersAndSportEventMustBeUnique() {

		JoinEventMember joinEventMember1 = new JoinEventMember();
		joinEventMember1.setTagName("David");
		joinEventMember1.setTelNum("0123456789");
		joinEventMember1.setPersonalId("1349900828068");
		joinEventMember1.setMembers(memberRepository.getOne(2L));
		joinEventMember1.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember1.setExpertLevels(expertLevelRepository.getOne(1L));
		entityManager.persist(joinEventMember1);
		entityManager.flush();


		JoinEventMember joinEventMember2 = new JoinEventMember();
		joinEventMember2.setTagName("Micheal");
		joinEventMember2.setTelNum("9876543210");
		joinEventMember2.setPersonalId("3330300724030");
		joinEventMember2.setMembers(memberRepository.getOne(2L));
		joinEventMember2.setSportEvent(sportsEventRepository.getOne(1L));
		joinEventMember2.setExpertLevels(expertLevelRepository.getOne(1L));

		try {
			entityManager.persist(joinEventMember2);
			entityManager.flush();
		}
		catch(javax.persistence.PersistenceException e){
			System.out.println("Test10 MembersAndSportEventMustBeUnique ===========");
			System.out.println(e);
			System.out.println("==============Test10 MembersAndSportEventMustBeUnique");
		}


	}

	@Test
	public void testExpertLevelNameNotBeNull() {
		ExpertLevel expertLevel = new ExpertLevel();
		expertLevel.setExpertLevelName(null);

		try {
			entityManager.persist(expertLevel);
			entityManager.flush();
			fail("Should not pass to this line");
		} catch(javax.validation.ConstraintViolationException e) {
			Set<ConstraintViolation<?>> violations = e.getConstraintViolations();
			assertEquals(violations.isEmpty(), false);
			assertEquals(violations.size(), 1);
			System.out.println("Test11 ExpertLevelNameNotBeNull ==============");
			System.out.println(e);
			System.out.println("================= Test11 ExpertLevelNameNotBeNull");
		}
	}


}

