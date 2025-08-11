package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeService {
    private Long nextID = 1L;
    @Autowired
    ChallengeRepository cr;

    public List<Challenge> getAllChallenges(){
        return cr.findAll();
    }

    public boolean addChallenge(Challenge ch){
        if(ch != null) {
            ch.setId(nextID++);
            cr.save(ch);
            return true;
        }
        else
            return false;
    }

    public Challenge getChallenge(String month){
        Optional<Challenge> challenge = cr.findByMonthIgnoreCase(month);
        return challenge.orElse(null);
    }

    public boolean updateChallenge(Long id, Challenge newC) {
        Optional<Challenge> challenge = cr.findById(id);
        if(challenge.isPresent()){
            Challenge challengeToUpdate = challenge.get();
            challengeToUpdate.setMonth(newC.getMonth());
            challengeToUpdate.setDescription(newC.getDescription());
            cr.save(challengeToUpdate);
            return true;
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        Optional<Challenge> challenge = cr.findById(id);
        if(challenge.isPresent()){
            cr.deleteById(id);
            return true;
        }
        return false;
    }
}
