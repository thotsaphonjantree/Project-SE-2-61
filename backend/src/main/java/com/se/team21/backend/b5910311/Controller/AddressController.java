package com.se.team21.backend.b5910311.controller;
import com.se.team21.backend.b5910311.entity.*;
import com.se.team21.backend.b5910311.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;
   

    @GetMapping("/address")
    public List<Address> showAlladdress() {
        return addressRepository.findAll().stream().collect(Collectors.toList());
    }
    
    @GetMapping("/address/{aid}")
    public Optional<Address> showLocationById(@PathVariable Long aid) {
        return addressRepository.findById(aid);
    }

    @PostMapping("/address/{code}/{addressname}")
    public Address createAddress(@PathVariable String code,@PathVariable String addressname){
        Address address = new Address();
        address.setCode(code);
        address.setAddressname(addressname);
        return addressRepository.save(address);
    }
}