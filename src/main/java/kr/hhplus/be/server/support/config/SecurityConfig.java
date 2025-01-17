package kr.hhplus.be.server.support.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable // Enable CSRF protection)
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/**", "/swagger-ui/**", "/v3/api-docs/**", "/error/**").permitAll() // 인증 없이 허용
                        .anyRequest().authenticated() // 나머지 요청은 인증 필요
                );
//                .formLogin(form -> form
//                        .loginPage("/login") // 커스텀 로그인 페이지
//                        .permitAll()
//                )
//                .logout(logout -> logout
//                        .logoutUrl("/logout")
//                        .logoutSuccessUrl("/login")
//                        .permitAll()
//                );

        return http.build();
    }

}
