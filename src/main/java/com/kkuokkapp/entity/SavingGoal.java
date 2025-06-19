package com.kkuokkapp.entity;

import jakarta.persistence.*;

@Entity
public class SavingGoal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private int goalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // --- Getter methods ---
    public Long getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public int getGoalAmount() {
        return goalAmount;
    }

    public User getUser() {
        return user;
    }

    // --- Setter methods ---
    public void setCategory(String category) {
        this.category = category;
    }

    public void setGoalAmount(int goalAmount) {
        this.goalAmount = goalAmount;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
