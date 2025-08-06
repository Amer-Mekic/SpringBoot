package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallengeController {
    private ChallengeService c;

    public ChallengeController(ChallengeService ch){
        c = ch;
    }

    @GetMapping("/challenges")
    public List<Challenge> getAllChallenges(){
        return c.getAllChallenges();
    }

    @PostMapping("/challenges")
    public String addChallenge(@RequestBody Challenge ch){
        boolean isAdded = c.addChallenge(ch);
        if(isAdded)
            return "Challenge added successfully";
        else
            return "Adding failed";
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getChallenge(
            @PathVariable String month){
        Challenge chl = c.getChallenge(month);
        if(chl!=null)
            return new ResponseEntity<>(chl, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
