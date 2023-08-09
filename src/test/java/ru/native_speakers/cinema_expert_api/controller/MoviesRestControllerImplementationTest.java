package ru.native_speakers.cinema_expert_api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.Mockito.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;
import ru.native_speakers.cinema_expert_api.service.MoviesService;

@WebMvcTest(controllers = MoviesRestControllerImplementation.class)
class MoviesRestControllerImplementationTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getMovieById_ReturnsCorrectResultIfMovieWithThisIdExists() throws Exception {
        int movieId = 76;
        mvc.perform(get("/movies/" + movieId))
                .andExpect(status().isOk());
    }
}
