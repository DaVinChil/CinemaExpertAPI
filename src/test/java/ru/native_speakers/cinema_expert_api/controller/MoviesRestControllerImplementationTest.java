package ru.native_speakers.cinema_expert_api.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.native_speakers.cinema_expert_api.dto.HttpEntityResponse;
import ru.native_speakers.cinema_expert_api.dto.MovieDTO;

import java.util.List;

@WebMvcTest(controllers = MoviesRestControllerImplementation.class)
class MoviesRestControllerImplementationTest {

    private final MockMvc mvc;
    private final ObjectMapper objectMapper;

    @Autowired
    public MoviesRestControllerImplementationTest(MockMvc mvc) {
        this.mvc = mvc;
        this.objectMapper = new ObjectMapper();
    }

    @Test
    void getMovieByMovieId_ReturnsHttpEntityResponseResultContainsOneMovieDTOIfMovieWithIdExist() throws Exception {
        int movieId = 1;
        String url = "/movies/" + movieId;
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();

        int status = result.getResponse().getStatus();
        assertThat(status).isEqualTo(HttpStatus.OK.value());

        String jsonContent = result.getResponse().getContentAsString();
        HttpEntityResponse<MovieDTO> response = mapFromJson(jsonContent, HttpEntityResponse.class);
        List<MovieDTO> httpEntityResult = response.result();
        assertThat(httpEntityResult.size()).isEqualTo(1);
    }

    private String mapToJson(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    private <T> T mapFromJson(String json, Class<T> clazz) throws JsonProcessingException {
        return objectMapper.readValue(json, clazz);
    }
}
