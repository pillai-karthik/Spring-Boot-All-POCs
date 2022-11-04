package com.karthik.allpocs.controllers;

import com.karthik.allpocs.entities.EntityOne;
import com.karthik.allpocs.services.EntityOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("ControllerOne")
public class ControllerOne {

    @Autowired
    private EntityOneService entityOneService;

    @GetMapping("/")
    public String firstApi(){
        return "First API of Controller One";
    }

    @GetMapping("/entity-ones")
    public List<EntityOne> secondApi(){
        return this.entityOneService.getEntityOnes();
    }

    @GetMapping("/entity-ones/{entityId}")
    public EntityOne thirdApi(@PathVariable int entityId){
        return this.entityOneService.getEntityOneById(entityId);
    }

    @PostMapping("/entity-ones")
    public EntityOne addEntityOne(@RequestBody EntityOne entityOne){
        return this.entityOneService.addEntityOne(entityOne);
    }

    @PutMapping("/entity-ones/{entityId}")
    public EntityOne editEntityOneById(@PathVariable int entityId, @RequestBody EntityOne entityOne){
        return this.entityOneService.editEntityOneById(entityId, entityOne);
    }

    @DeleteMapping("/entity-ones/{entityId}")
    public EntityOne deleteEntityOneById(@PathVariable int entityId){
        return this.entityOneService.deleteEntityOneById(entityId);
    }
}
