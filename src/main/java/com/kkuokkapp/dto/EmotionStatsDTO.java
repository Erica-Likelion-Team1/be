package com.kkuokkapp.dto;

public class EmotionStatsDTO {
    public int totalRecords;
    public double averageScore;
    public double positiveRate; // 비율 (0~1)

    public EmotionStatsDTO(int totalRecords, double averageScore, double positiveRate) {
        this.totalRecords = totalRecords;
        this.averageScore = averageScore;
        this.positiveRate = positiveRate;
    }
}
