package com.kkuokkapp.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class ConsumptionRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private int amount;
    private LocalDate date;

    private String emotion;
    private int emotionScore;
    private String reason;
    private boolean remindLater;

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

    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getEmotion() {
        return emotion;
    }

    public int getEmotionScore() {
        return emotionScore;
    }

    public String getReason() {
        return reason;
    }

    public boolean isRemindLater() {
        return remindLater;
    }

    public User getUser() {
        return user;
    }

    // --- Setter methods ---
    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEmotion(String emotion) {
        this.emotion = emotion;
    }

    public void setEmotionScore(int emotionScore) {
        this.emotionScore = emotionScore;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setRemindLater(boolean remindLater) {
        this.remindLater = remindLater;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
