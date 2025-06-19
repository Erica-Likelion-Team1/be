package com.kkuokkapp.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ConsumptionRecord> records;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<SavingGoal> goals;
}
