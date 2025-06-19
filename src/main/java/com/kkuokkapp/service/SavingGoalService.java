package com.kkuokkapp.service;

import com.kkuokkapp.entity.SavingGoal;
import com.kkuokkapp.entity.User;
import com.kkuokkapp.repository.SavingGoalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingGoalService {

    @Autowired
    private SavingGoalRepository goalRepository;

    public SavingGoal saveGoal(SavingGoal goal) {
        return goalRepository.save(goal);
    }

    public List<SavingGoal> getGoalsByUser(User user) {
        return goalRepository.findByUser(user);
    }
}
