package com.se.team21.backend.B5926329.Controller;


import com.se.team21.backend.B5926329.Entity.Payment;
import com.se.team21.backend.B5926329.Repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PaymentController {

    @Autowired
    PaymentRepository paymentRepository;

    @GetMapping("/payments")
    public List<Payment> showAllPayment(){
        return paymentRepository.findAll().stream().collect(Collectors.toList());
    }

}
