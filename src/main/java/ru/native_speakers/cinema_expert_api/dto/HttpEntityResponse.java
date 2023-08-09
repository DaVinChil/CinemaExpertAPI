package ru.native_speakers.cinema_expert_api.dto;

import java.util.List;

public record HttpEntityResponse<T>(List<T> result) {
}
