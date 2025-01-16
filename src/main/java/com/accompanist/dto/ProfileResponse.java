package com.accompanist.dto;

import com.accompanist.domain.AccompanistProfile;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class ProfileResponse {
    private Long id;
    private List<String> instruments;
    private String experience;
    private String introduction;
    private Integer hourlyRate;
    private String grade;
    private Integer totalPerformances;
    private Double averageRating;

    public static ProfileResponse from(AccompanistProfile profile) {
        return ProfileResponse.builder()
                .id(profile.getId())
                .instruments(profile.getInstruments())
                .experience(profile.getExperience())
                .introduction(profile.getIntroduction())
                .hourlyRate(profile.getHourlyRate())
                .grade(profile.getGrade())
                .totalPerformances(profile.getTotalPerformances())
                .averageRating(profile.getAverageRating())
                .build();
    }
}