package com.se.team21.backend.B5926329.Controller;


import com.se.team21.backend.B5926329.Entity.Member;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

    @Autowired
    MemberRepository memberRepository;


    @GetMapping("/members")
    public List<Member> members() {
        return memberRepository.findAll().stream() .collect(Collectors.toList());
    }

    @PostMapping("/memberlogin/auth/{username}/{password}")
    public ResponseEntity<Map<String, Object>> authMember(@PathVariable("username") String username, @PathVariable("password") String password){
        Member member =  this.memberRepository.findByUsernameAndPassword(username,password);
        Map<String, Object> json = new HashMap<String, Object>();
        if(member != null){
            json.put("success", true);
            json.put("status", "auth");
            json.put("member", member);
            return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.OK));

        }else {
            json.put("success", false);
            json.put("status", "Unauth");
            json.put("member", "");
            return  (new ResponseEntity<Map<String, Object>>(json, null, HttpStatus.NOT_FOUND));
        }
    }

}
