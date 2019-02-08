package com.se.team21.backend.B5926329.Sprint2.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.se.team21.backend.B5926329.Repository.EventRepository;
import com.se.team21.backend.B5926329.Repository.MemberRepository;
import com.se.team21.backend.B5926329.Sprint2.Entity.ExpertLevel;
import com.se.team21.backend.B5926329.Sprint2.Entity.JoinEventMember;
import com.se.team21.backend.B5926329.Sprint2.Repository.ExpertLevelRepository;
import com.se.team21.backend.B5926329.Sprint2.Repository.JoinEventMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class JoinEventMemberController {

    @Autowired
    JoinEventMemberRepository joinEventMemberRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ExpertLevelRepository expertLevelRepository;

    @Autowired
    com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;

    @GetMapping("/joineventmembers")
    public List<JoinEventMember> showAllExpertLevel() {
        return joinEventMemberRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/joinevent/save")
    public JoinEventMember createJoinEventMember(@RequestBody String dataJoin)throws JsonParseException, IOException {

        final String decoded = URLDecoder.decode(dataJoin, "UTF-8");
        dataJoin = decoded;

        ObjectMapper mapper = new ObjectMapper();
        JsonNode actualObj = mapper.readTree(dataJoin);


        JsonNode jsonUserId = actualObj.get("userId");
        JsonNode jsonEventId = actualObj.get("eventId");
        JsonNode jsonExpertLevelId = actualObj.get("expertlevelId");
        JsonNode jsontel = actualObj.get("tel");
        JsonNode jsonTagName = actualObj.get("tagName");
        JsonNode jsonPersonalId = actualObj.get("personalId");


        JoinEventMember joinEventMember = new JoinEventMember();
        joinEventMember.setMembers(memberRepository.getOne(jsonUserId.asLong()));
        joinEventMember.setSportEvent(sportsEventRepository.getOne(jsonEventId.asLong()));
        joinEventMember.setExpertLevels(expertLevelRepository.getOne(jsonExpertLevelId.asLong()));
        joinEventMember.setTelNum(jsontel.asText());
        joinEventMember.setTagName(jsonTagName.asText());
        joinEventMember.setPersonalId(jsonPersonalId.asText());
        return joinEventMemberRepository.save(joinEventMember);

    }

    @GetMapping("jointbymember/{mid}")
    public List<JoinEventMember> showJoinEventByMember(@PathVariable Long mid) {
        return joinEventMemberRepository.findByMembers_MemberId(mid);
    }
}
