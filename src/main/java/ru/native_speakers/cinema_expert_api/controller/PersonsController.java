package ru.native_speakers.cinema_expert_api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PersonsController {
    @GetMapping("/actors/by-movie-id")

}
