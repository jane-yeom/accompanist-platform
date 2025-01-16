package com.accompanist.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProfileRequest {
    @NotEmpty(message = "악기는 필수입니다.")
    private List<String> instruments;

    @NotNull(message = "경력사항은 필수입니다.")
    private String experience;

    @NotNull(message = "자기소개는 필수입니다.")
    private String introduction;

    @NotNull(message = "시간당 금액은 필수입니다.")
    @Min(value = 0, message = "시간당 금액은 0보다 커야 합니다.")
    private Integer hourlyRate;
}
