package ru.native_speakers.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;

    @Column(name = "name")
    @NotNull(message = "Character's name should not be null")
    @NotEmpty(message = "Character's name should not be empty")
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "movie_id", referencedColumnName = "movie_id")
    @NotNull(message = "Character's movie should not be null")
    private Movie movie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "actor_id", referencedColumnName = "person_id")
    @NotNull(message = "Character's actor should not be null")
    private Person actor;
}
