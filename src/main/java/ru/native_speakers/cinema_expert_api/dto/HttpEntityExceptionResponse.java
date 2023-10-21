package ru.native_speakers.cinema_expert_api.dto;

import java.util.List;

public record HttpEntityExceptionResponse(String errorMessage, List<Object> result) {}
