package com.kkuokkapp.repository;

import com.kkuokkapp.entity.SavingGoal;
import com.kkuokkapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingGoalRepository extends JpaRepository<SavingGoal, Long> {
    List<SavingGoal> findByUser(User user);
}
