package com.kkuokkapp.service;

import com.kkuokkapp.dto.ConsumptionRecordDTO;
import com.kkuokkapp.dto.EmotionStatsDTO;
import com.kkuokkapp.entity.ConsumptionRecord;
import com.kkuokkapp.entity.User;
import com.kkuokkapp.repository.ConsumptionRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/consumption")
public class ConsumptionController {

    @Autowired
    private ConsumptionService consumptionService;

    @Autowired
    private UserService userService;

    @PostMapping("/{userId}")
    public ConsumptionRecord saveRecord(@PathVariable Long userId, @RequestBody ConsumptionRecord record) {
        User user = userService.getUserById(userId).orElseThrow();
        record.setUser(user);
        return consumptionService.saveRecord(record);
    }

    @GetMapping("/{userId}")
    public List<ConsumptionRecord> getRecords(@PathVariable Long userId) {
        User user = userService.getUserById(userId).orElseThrow();
        return consumptionService.getRecordsByUser(user);
    }

    @PostMapping("/{userId}/with-emotion")
    public ConsumptionRecord saveWithEmotion(@PathVariable Long userId, @RequestBody ConsumptionRecordDTO dto) {
        User user = userService.getUserById(userId).orElseThrow();

        ConsumptionRecord record = new ConsumptionRecord();
        record.setUser(user);
        record.setCategory(dto.category);
        record.setAmount(dto.amount);
        record.setDate(dto.date);
        record.setEmotion(dto.emotion);
        record.setEmotionScore(dto.getEmotionScore());
        record.setReason(dto.reason);
        record.setRemindLater(dto.remindLater);

        return consumptionService.saveRecord(record);
    }

    @GetMapping("/{userId}/stats")
    public EmotionStatsDTO getStats(@PathVariable Long userId,
                                    @RequestParam String from,
                                    @RequestParam String to) {
        User user = userService.getUserById(userId).orElseThrow();
        java.time.LocalDate start = java.time.LocalDate.parse(from);
        java.time.LocalDate end = java.time.LocalDate.parse(to);
        return consumptionService.getEmotionStats(user, start, end);
    }
}
