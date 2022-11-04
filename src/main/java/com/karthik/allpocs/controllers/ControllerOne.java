package com.karthik.allpocs.controllers;

import com.karthik.allpocs.entities.EntityOne;
import com.karthik.allpocs.services.EntityOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("ControllerOne")
public class ControllerOne {

    @Autowired
    private EntityOneService entityOneService;

    @GetMapping("/api-one")
    public String firstApi(){
        return "First API";
    }

    @GetMapping("/api-two")
    public List<EntityOne> secondApi(){
        return this.entityOneService.getEntityOnes();
    }

}
