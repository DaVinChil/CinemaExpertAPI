package ru.native_speakers.cinema_expert_api.dto.persons;

import lombok.Builder;
import lombok.Data;
import ru.native_speakers.cinema_expert_api.model.Image;

import java.sql.Date;
import java.util.List;

@Data
public class ActorsByMovie {
    private List<Actor> actors;
    public void addActor(Actor actor){
        actors.add(actor);
    }
    @Data
    @Builder
    static class Actor {
        private String imdbId;
        private String fullName;
        private String gender;
        private double height;
        private Date birthday;
        private String birthPlace;
        private Date deathDate;
        private String deathCause;
        private String deathPlace;
        private Image photo;
        private List<String> characters;
        private List<String> filmography;
    }
}


