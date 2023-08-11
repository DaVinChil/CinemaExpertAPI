package ru.native_speakers.cinema_expert_api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import ru.native_speakers.cinema_expert_api.service.MoviesService;

@WebMvcTest(controllers = MoviesRestControllerImplementation.class)
class MoviesRestControllerImplementationTest {

    private MockMvc mvc;
    private MoviesService moviesService;

    public MoviesRestControllerImplementationTest(MockMvc mvc,
                                                  @Qualifier("moviesServiceImplementation") MoviesService moviesService) {
        this.mvc = mvc;
        this.moviesService = moviesService;
    }


}
