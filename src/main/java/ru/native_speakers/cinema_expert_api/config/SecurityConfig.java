package ru.native_speakers.cinema_expert_api.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JWTExceptionHandlerFilter jwtExceptionHandlerFilter;
    private final UserDetailsService userDetailsService;
    private final JWTFilter jwtFilter;
    private final AuthenticationExceptionHandlerFilter authenticationExceptionHandlerFilter;
    private final AccessDeniedExceptionHandlerFilter accessDeniedHandler;

    public SecurityConfig(@Qualifier("userServiceImpl") UserDetailsService userDetailsService,
                          JWTFilter jwtFilter, JWTExceptionHandlerFilter jwtExceptionHandlerFilter,
                          AuthenticationExceptionHandlerFilter authenticationExceptionHandlerFilter,
                          @Qualifier("accessDeniedExceptionHandlerFilter") AccessDeniedExceptionHandlerFilter accessDeniedHandler) {
        this.userDetailsService = userDetailsService;
        this.jwtFilter = jwtFilter;
        this.authenticationExceptionHandlerFilter = authenticationExceptionHandlerFilter;
        this.jwtExceptionHandlerFilter = jwtExceptionHandlerFilter;
        this.accessDeniedHandler = accessDeniedHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/auth/**").permitAll()
                        .anyRequest().authenticated())
                .authenticationProvider(daoAuthenticationProvider())
                .sessionManagement(sessionManagement -> sessionManagement
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(jwtExceptionHandlerFilter, jwtFilter.getClass())
                .addFilterBefore(authenticationExceptionHandlerFilter, jwtExceptionHandlerFilter.getClass())
                .addFilterAfter(accessDeniedHandler, authenticationExceptionHandlerFilter.getClass());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }
}
