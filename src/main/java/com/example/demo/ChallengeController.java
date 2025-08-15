package com.example.demo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/challenges") // base URL for http methods of whole controller class
@CrossOrigin(origins="http://localhost:5173")
public class ChallengeController {
    private ChallengeService c;

    public ChallengeController(ChallengeService ch){
        c = ch;
    }

    @GetMapping
    public List<Challenge> getAllChallenges(){
        return c.getAllChallenges();
    }

    @PostMapping
    public String addChallenge(@RequestBody Challenge ch){
        boolean isAdded = c.addChallenge(ch);
        if(isAdded)
            return "Challenge added successfully";
        else
            return "Adding failed";
    }

    @GetMapping("/{month}")
    public ResponseEntity<Challenge> getChallenge(
            @PathVariable String month){
        Challenge chl = c.getChallenge(month);
        if(chl!=null)
            return new ResponseEntity<>(chl, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateChallenge(@PathVariable Long id, @RequestBody  Challenge newC){
        boolean isUpdated = c.updateChallenge(id, newC);
        if(isUpdated)
            return new ResponseEntity<>("Challenge updated successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteChallenge(@PathVariable Long id){
        boolean isDeleted = c.deleteChallenge(id);
        if(isDeleted)
            return new ResponseEntity<>("Challenge deleted successfully", HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
