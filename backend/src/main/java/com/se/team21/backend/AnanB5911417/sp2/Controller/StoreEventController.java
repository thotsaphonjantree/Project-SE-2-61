package com.se.team21.backend.AnanB5911417.sp2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.se.team21.backend.AnanB5911417.sp2.Repository.*;
import com.se.team21.backend.AnanB5911417.sp2.Entity.*;
import com.se.team21.backend.b5910311.entity.SportsEvent;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class StoreEventController {

    @Autowired
    EventStoreRepository eventStoreRepository ;    
    @Autowired
    StoreTypeRepository storeTypeRepository ;    
    @Autowired
    com.se.team21.backend.B5901890.Repository.RegisterStaffRepository staffRepository;
    @Autowired
    com.se.team21.backend.b5910311.repository.SportsEventRepository sportsEventRepository;
    

    @GetMapping("/showstore")
    public List<EventStore> showAllStores(){
        return eventStoreRepository.findAll().stream().collect(Collectors.toList());
    }
    @GetMapping("/showstoretype")
    public List<StoreType> showAllStoreType(){
        return storeTypeRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/store/create/{storename}/{eventI}/{octime}/{storetelI}/{storeTypeUI}")
    public EventStore createReservePlace(@PathVariable String storename,
                                         @PathVariable Long eventI,
                                         @PathVariable String octime,
                                         @PathVariable String storetelI,
                                         @PathVariable Long storeTypeUI)
     {
       
        EventStore eventStore = new EventStore();
        
        eventStore.setSportEventFStore(sportsEventRepository.getOne(eventI));
        eventStore.setSetTypeStoreFStore(storeTypeRepository.getOne(storeTypeUI));
        eventStore.setStoreName(storename);
        eventStore.setOctime(octime);
        eventStore.setStoreTel(storetelI);
            return eventStoreRepository.save(eventStore);
    }

    @PutMapping(path = "/updateStore/{storeIdUI}/{storeName}/{octime}/{sportEventFstore}/{typeStoreFStore}/{storetel}")
    public EventStore editEventStore(@RequestBody EventStore editEventStore,
                                     @PathVariable Long storeIdUI,
                                      @PathVariable String storeName,
                                       @PathVariable String octime,
                                        @PathVariable Long sportEventFstore,
                                         @PathVariable Long typeStoreFStore,
                                         @PathVariable String storetel){
        StoreType type = storeTypeRepository.getOne(typeStoreFStore);
        SportsEvent s = sportsEventRepository.getOne(sportEventFstore);
        return eventStoreRepository.findById(storeIdUI).map(storeEdit ->{
            storeEdit.setStoreId(storeIdUI);
            storeEdit.setStoreTel(storetel);
            storeEdit.setStoreName(storeName);
            storeEdit.setOctime(octime);
            storeEdit.setSportEventFStore(s);
            storeEdit.setSetTypeStoreFStore(type);
            

                    return eventStoreRepository.save(storeEdit);
                }
        ).orElseGet(() ->{
            return eventStoreRepository.save(editEventStore);
        });
    }

}