package com.se.team21.backend.B5926329.Controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Entity.PayCategory;
import com.se.team21.backend.B5926329.Entity.Payment;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Repository.PayCategoryRepository;
import com.se.team21.backend.B5926329.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    /*@Autowired
    EventRepository eventRepository;*/

    @Autowired
    com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;
    @Autowired
    MemberRepository memberRepository;

    @Autowired
    PayCategoryRepository payCategoryRepository;



    @PostMapping("/payment/save")
    public Payment createComment(@RequestBody String dataPayment)throws JsonParseException,IOException {

        final String decoded = URLDecoder.decode(dataPayment, "UTF-8");
        dataPayment = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataPayment);


        JsonNode jsonUsername = actualObj.get("username");
        JsonNode jsonEventName = actualObj.get("eventname");
        JsonNode jsonPaid = actualObj.get("paid");
        JsonNode jsonPaycate = actualObj.get("paycatename");


        Payment payment = new Payment();

        Date date = new Date();

        payment.setSportEvent(sportsEventRepository.getOne(jsonEventName.asLong()));
        payment.setPayCategory(payCategoryRepository.getOne(jsonPaycate.asLong()));
        payment.setMembers(memberRepository.getOne(jsonUsername.asLong()));
        payment.setPaymentPaid(jsonPaid.asLong());
        payment.setPaymentDate(new Timestamp(date.getTime()));
        return paymentRepository.save(payment);

    }


    @GetMapping("/payments")
    public List<Payment> showAllPayment(){
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("payment/{mid}")
    public List<Payment> showPaymentById(@PathVariable Long mid) {
        return paymentRepository.findByMembers_MemberId(mid);
    }

    /*@GetMapping("/events")
    public List<Event> showAllEvent(){
        return eventRepository.findAll().stream().collect(Collectors.toList());
    }*/

    @GetMapping("/member/{mid}")
    public Member getMemberById(@PathVariable Long mid) {
        Optional<Member> member = memberRepository.findById(mid);
        return member.get();
    }

    @GetMapping("/paycates")
    public List<PayCategory> showAllPayCate(){
        return payCategoryRepository.findAll().stream().collect(Collectors.toList());
    }

    /*@GetMapping("event/{eid}")
    public Event showEventByEid(@PathVariable Long eid) {
        Optional<Event> event = eventRepository.findById(eid);
        return event.get();
    }*/
}
