package id.co.cryptocore.cryptoapi.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/crypto/**").hasAnyAuthority("user","admin")
                .requestMatchers(HttpMethod.POST, "/crypto/**").hasAnyAuthority("user","admin")
                .requestMatchers(HttpMethod.PUT, "/crypto/**").hasAnyAuthority("user","admin")
                .requestMatchers(HttpMethod.GET,"/admin/**").hasAnyAuthority("admin")
                .requestMatchers(HttpMethod.POST,"/admin/**").hasAnyAuthority("admin")
                .requestMatchers(HttpMethod.PUT,"/admin/**").hasAnyAuthority("admin")
                .requestMatchers(HttpMethod.DELETE,"/admin/**").hasAnyAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();

        return http.build();
    }


}
