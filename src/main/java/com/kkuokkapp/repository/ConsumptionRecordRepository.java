package com.kkuokkapp.repository;

import com.kkuokkapp.entity.ConsumptionRecord;
import com.kkuokkapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConsumptionRecordRepository extends JpaRepository<ConsumptionRecord, Long> {
    List<ConsumptionRecord> findByUser(User user);

    List<ConsumptionRecord> findByUserAndDateBetween(User user, java.time.LocalDate start, java.time.LocalDate end);
    
}
