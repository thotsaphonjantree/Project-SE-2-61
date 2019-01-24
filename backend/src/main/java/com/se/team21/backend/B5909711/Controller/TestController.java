package com.se.team21.backend.B5909711.Controller;

import com.se.team21.backend.B5909711.Entity.TestEntity;
import com.se.team21.backend.B5909711.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController @CrossOrigin(origins = "http://localhost:4200")
public class TestController {
    @Autowired
    private TestRepository testRepository;

    @Autowired
    public TestController(TestRepository testRepository){
        this.testRepository = testRepository;
    }

    @GetMapping("/Test")
    public Collection<TestEntity> gettActivities(){
        return testRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/Test/{tName}/{tActivities}/{tAddress}")
    public TestEntity testEntity(@PathVariable String tName, @PathVariable String tActivities, @PathVariable String tAddress){
        TestEntity t = new TestEntity();
        t.settName(tName);
        t.settAddress(tAddress);
        t.settActivities(tActivities);

        return testRepository.save(t);
    }
}
