package com.project.cr.config;

import com.project.cr.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    // flujo de spring security
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
       return httpSecurity
               .csrf(AbstractHttpConfigurer::disable)
               .httpBasic(Customizer.withDefaults())
               .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               .authorizeHttpRequests(http -> {

                   // endpoinds publicos
                   http.requestMatchers(HttpMethod.GET, "/card/all").permitAll();
                   http.requestMatchers(HttpMethod.GET, "/card/search/{palabra}").permitAll();
                   http.requestMatchers(HttpMethod.GET, "/card/{tipo}").permitAll();

                   //endpoinst privadas
                   http.requestMatchers(HttpMethod.POST, "/estructura/create")
                           .hasAuthority("CREATE");
                   http.requestMatchers(HttpMethod.PATCH, "/estructura/update/{id}")
                           .hasRole("DEVELOPER");
                   http.requestMatchers(HttpMethod.POST, "/tropa/create")
                           .hasAuthority("CREATE");
                   http.requestMatchers(HttpMethod.PATCH, "/tropa/update/{id}")
                           .hasRole("DEVELOPER");
                   http.requestMatchers(HttpMethod.POST, "/hechizo/create")
                           .hasAuthority("CREATE");
                   http.requestMatchers(HttpMethod.PATCH, "/hechizo/update/{id}")
                           .hasRole("DEVELOPER");

                   // endpoint no configuradas
                   http.anyRequest().denyAll();
               })
               .build();
    }

    @Bean
    public AuthenticationManager manager(AuthenticationConfiguration configuration)
            throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider provider(UserDetailsServiceImpl userDetailsService){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


}
