package com.example.demo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges = new ArrayList<>();
    private Long nextID = 1L;

    public List<Challenge> getAllChallenges(){
        return challenges;
    }

    public boolean addChallenge(Challenge ch){
        if(ch != null) {
            ch.setId(nextID++);
            challenges.add(ch);
            return true;
        }
        else
            return false;
    }

    public Challenge getChallenge(String month){
        for(Challenge c : challenges){
            if(c.getMonth().equalsIgnoreCase(month))
                    return c;
        }
        return null;
    }

    public boolean updateChallenge(Long id, Challenge newC) {
        for(Challenge c : challenges){
            if(c.getId().equals(id)) {
                c.setMonth(newC.getMonth());
                c.setDescription(newC.getDescription());
                return true;
            }
        }
        return false;
    }

    public boolean deleteChallenge(Long id) {
        return challenges.removeIf(ch -> ch.getId().equals(id));
    }
}
