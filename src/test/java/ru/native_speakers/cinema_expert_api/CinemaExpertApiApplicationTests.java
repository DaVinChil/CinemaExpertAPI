package ru.native_speakers.cinema_expert_api;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.native_speakers.cinema_expert_api.controller.MoviesController;

@SpringBootTest
class CinemaExpertApiApplicationTests {

    @Autowired
    private MoviesController moviesController;

    @Test
    void contextLoads() {
        assertNotNull(moviesController);
    }

}
