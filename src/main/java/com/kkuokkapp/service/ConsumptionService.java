package com.kkuokkapp.service;

import com.kkuokkapp.dto.EmotionStatsDTO;
import com.kkuokkapp.entity.ConsumptionRecord;
import com.kkuokkapp.entity.User;
import com.kkuokkapp.repository.ConsumptionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class ConsumptionService {

    @Autowired
    private ConsumptionRecordRepository recordRepository;

    public ConsumptionRecord saveRecord(ConsumptionRecord record) {
        return recordRepository.save(record);
    }

    public List<ConsumptionRecord> getRecordsByUser(User user) {
        return recordRepository.findByUser(user);
    }

public EmotionStatsDTO getEmotionStats(User user, java.time.LocalDate from, java.time.LocalDate to) {
    var records = recordRepository.findByUserAndDateBetween(user, from, to);
    if (records.isEmpty()) {
        return new EmotionStatsDTO(0, 0.0, 0.0);
    }
    int total = records.size();
    int scoreSum = 0;
    int positive = 0;
    for (var r : records) {
        scoreSum += r.getEmotionScore();
        if (r.getEmotionScore() >= 60) { // 60 이상을 positive로 가정
            positive++;
        }
    }
    double avg = scoreSum / (double) total;
    double positiveRate = positive / (double) total;
    return new EmotionStatsDTO(total, avg, positiveRate);
}

}
