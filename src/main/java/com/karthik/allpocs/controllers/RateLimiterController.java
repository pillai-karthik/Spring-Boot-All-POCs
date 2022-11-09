package com.karthik.allpocs.controllers;

import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Bucket4j;
import io.github.bucket4j.Refill;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
@RequestMapping("/rate-limit")
public class RateLimiterController {

    private Bucket bucket;

    @GetMapping("/token-generate")
    public ResponseEntity<String> generateToken(){
        Refill refill=Refill.of(5, Duration.ofMinutes(1));

        bucket= Bucket4j.builder()
                .addLimit(Bandwidth.classic(5,refill))
                .build();

        return new ResponseEntity<String>("Bucket initialize hua"+bucket.toString(), HttpStatus.OK);
    }

    @GetMapping("/consume-token")
    public ResponseEntity<String> demo(){

        try {
            if (bucket.tryConsume(1)) {
                return new ResponseEntity<String>("Result retrieved! Token consumed. Available Token - "+bucket.getAvailableTokens(), HttpStatus.OK);
            } else {
                return new ResponseEntity<String>("Too many hits! Please try again!", HttpStatus.TOO_MANY_REQUESTS);
            }
        }catch (Exception e){
            return new ResponseEntity<String>("Generate Token first!", HttpStatus.BAD_REQUEST);
        }

    }

}
