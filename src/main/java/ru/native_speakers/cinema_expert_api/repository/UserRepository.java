package ru.native_speakers.cinema_expert_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.native_speakers.cinema_expert_api.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = """
                    select users.* from users
                    join user_authorization on user_authorization.authorization_id = users.authorization_id
                    where user_authorization.refresh_token = :token
                    """,
            nativeQuery = true
    )
    Optional<User> findUserByRefreshToken(@Param("token") String refreshToken);
    Optional<User> findByUsername(String username);
}
