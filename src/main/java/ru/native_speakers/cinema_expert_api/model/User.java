package ru.native_speakers.cinema_expert_api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    @Column(name = "username")
    @Size(min = 4, message = "Username should have at least 4 characters")
    private String username;

    @Column(name = "password")
    @Size(min = 8, message = "Password should have at least 8 characters")
    private String password;

    @Column(name = "created_at")
    @NotNull(message = "Created date cannot be null")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdAt;
}
