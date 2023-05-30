package ru.mobile.effective.SocialMediaAPI.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers("/**").permitAll() // Разрешить доступ к URL-адресам /public/** без аутентификации
                        .anyRequest().authenticated() // Все остальные URL-адреса требуют аутентификации
                )
                .formLogin(Customizer.withDefaults()) // Отключить форму входа (login form)
                .build();
    }
}