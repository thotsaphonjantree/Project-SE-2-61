package com.se.team21.backend;

import com.se.team21.backend.B5926329.Entity.Event;
import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Entity.PayCategory;
import com.se.team21.backend.B5926329.Entity.Payment;
import com.se.team21.backend.B5926329.Repository.EventRepository;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Repository.PayCategoryRepository;
import com.se.team21.backend.B5926329.Repository.PaymentRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean
    ApplicationRunner init(MemberRepository memberRepository, PayCategoryRepository payCategoryRepository,
						   EventRepository eventRepository, PaymentRepository paymentRepository){
		return args -> {

			/*Member*/ Stream.of( "david01","paul06").forEach(username -> {
				Member member = new Member();
				member.setUsername(username);

				if(username == "david01"){
					member.setPassword("1111");
					member.setName("daviddegea");
				}
				else if(username == "paul06"){
					member.setPassword("6666");
					member.setName("paulpogba");
				}
				memberRepository.save(member);
			});

			/*PayCategory*/Stream.of("Wallet","PayPal").forEach(paycate -> {
				PayCategory payCategory = new PayCategory();
				payCategory.setPaycateName(paycate);
				payCategoryRepository.save(payCategory);
			});

			/*Event*/Stream.of("Running","Swimming").forEach(evt -> {
				Event event = new Event();
				event.setEvenName(evt);
					if(evt == "Running"){
						event.setEvenPrice(500L);
					}
					else if(evt == "Swimming"){
						event.setEvenPrice(300L);
					}
				eventRepository.save(event);
			});


            /*Payments*/Stream.of(300L,500L).forEach(paid -> {
                Payment payment = new Payment();
                payment.setPaymentPaid(paid);
                if(paid == 300L){
                    payment.setMembers(memberRepository.getOne(2L));
                    payment.setPayCategory(payCategoryRepository.getOne(1L));
                    payment.setSportEvent(eventRepository.getOne(2L));
                }
                else if(paid == 500L){
                    payment.setMembers(memberRepository.getOne(1L));
                    payment.setPayCategory(payCategoryRepository.getOne(2L));
                    payment.setSportEvent(eventRepository.getOne(1L));
                }
                paymentRepository.save(payment);
            });
		};

		};


	} 	



