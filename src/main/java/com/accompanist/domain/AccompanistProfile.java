package com.accompanist.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
public class AccompanistProfile {
    private Long id;
    private Long userId;
    private List<String> instruments;    // 악기 목록
    private String experience;           // 경력 사항
    private String introduction;         // 자기소개
    private String grade;                // 음표 등급
    private Integer hourlyRate;          // 시간당 금액
    private Integer totalPerformances;   // 총 공연 횟수
    private Double averageRating;        // 평균 평점
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @Builder
    public AccompanistProfile(Long userId, List<String> instruments,
                            String experience, String introduction,
                            Integer hourlyRate) {
        this.userId = userId;
        this.instruments = instruments;
        this.experience = experience;
        this.introduction = introduction;
        this.hourlyRate = hourlyRate;
        this.grade = "EIGHTH_NOTE";     // 초기 등급
        this.totalPerformances = 0;
        this.averageRating = 0.0;
    }
}