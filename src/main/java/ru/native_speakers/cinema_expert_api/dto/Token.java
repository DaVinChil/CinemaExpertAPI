package ru.native_speakers.cinema_expert_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Token {
    private String value;
    private Date issuedAt;
    private Date expiresAt;
}
