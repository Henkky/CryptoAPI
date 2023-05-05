package id.co.cryptocore.cryptoapi.config;


import id.co.cryptocore.cryptoapi.service.CryptoUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
//    @Bean
//    public UserDetailsService userDetailsService(){
//        return new CryptoUserService();
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//        http
//                .authorizeRequests()
//                .requestMatchers(HttpMethod.GET,"/getaccounts").permitAll()
//                .requestMatchers(HttpMethod.GET,"/hello").hasAuthority("user")
//                .anyRequest().authenticated()
//                .and()
//                .csrf()
//                .disable();
        //https://stackoverflow.com/questions/31746466/spring-security-always-returns-http-403
        //https://www.baeldung.com/spring-security-expressions
        //https://docs.spring.io/spring-security/reference/servlet/authorization/authorize-http-requests.html
        http
                .csrf().disable()
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET, "/getaccounts").permitAll()
//                .requestMatchers(HttpMethod.GET, "/**").hasAnyAuthority("ROLE_user","user")
//                .requestMatchers(HttpMethod.GET, "/add").hasAnyAuthority("admin")
//                .requestMatchers(HttpMethod.POST,"/**").hasAnyAuthority("admin")
//                .requestMatchers(HttpMethod.PUT,"/**").hasAnyAuthority("admin")
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .logout().permitAll();

        return http.build();
    }


}
