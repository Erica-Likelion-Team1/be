package com.kkuokkapp.dto;

import java.time.LocalDate;

public class ConsumptionRecordDTO {
    public String category;
    public int amount;
    public LocalDate date;
    public String emotion;       // ex: "좋음"
    public String reason;
    public boolean remindLater;

    public int getEmotionScore() {
        return switch (emotion) {
            case "완전 좋음" -> 100;
            case "좋음"     -> 80;
            case "그럭저럭" -> 60;
            case "나쁨"     -> 40;
            case "끔찍함"   -> 20;
            default -> 0;
        };
    }
}
