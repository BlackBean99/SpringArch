package com.example.demo.global.config;

import com.example.demo.global.common.BasicResponse;
import com.example.demo.global.common.exception.CustomAuthenticationEntryPoint;
import com.example.demo.global.config.jwt.JwtAuthenticationFilter;
import com.example.demo.global.config.jwt.JwtProvider;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//package com.example.demo.global.config;
//
//import com.example.demo.global.config.jwt.JwtAuthenticationFilter;
//import com.example.demo.global.config.jwt.JwtProvider;
//import io.swagger.v3.oas.annotations.OpenAPIDefinition;
//import io.swagger.v3.oas.annotations.info.Info;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtProvider jwtTokenProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final ObjectMapper objectMapper;
//    private final CustomAuthenticationEntryPoint customAuthenticationEntryPoint;

//    Swagger Configuration
    @Bean
    public WebSecurityCustomizer configure(){
        return (web) -> web.ignoring().mvcMatchers(
                "v3/api-docs"
                ,"swagger-ui/**"
        );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.antMatcher("/**")
                .authorizeRequests()
//                .antMatchers("/api/v1/**").hasAuthority(USER.name())
                .and()
                .httpBasic().disable()
                .cors().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()// 시큐리티 처리에 HttpServeltRequest를 사용합니다.
                .anyRequest().permitAll()
                .and()
                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
                        UsernamePasswordAuthenticationFilter.class)  //JwtAuthenticationFilter를 UsernamePasswordAuthenticationFilter 전에 넣는다
                .exceptionHandling()    //Exception Handler
                .authenticationEntryPoint(((request, response, authException) -> {
                    response.setStatus(HttpStatus.UNAUTHORIZED.value());
                    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                    objectMapper.writeValue(
                            response.getOutputStream(),
                            new BasicResponse("exception event",HttpStatus.FORBIDDEN)
                    );
                })).and().build();
//                AccessDenied Handler


    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()  //  security login 해제
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 토큰 기반 인증이므로 세션 X
//                .and()
//                .authorizeRequests()
//                .antMatchers("/join", "/login", "/user/signup", "/user/login", "/exception/**", "/configuration/**")
//                .permitAll()
//                .antMatchers("/v2/api-docs", "/swagger-ui*/**", "/webjars/**")
//                .permitAll()
////                .antMatchers("/admin/**").hasRole("ADMIN")
////                .antMatchers("/user/**").hasRole("USER")
////                .anyRequest().authenticated()
//                .and()
//                .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider),
//                        UsernamePasswordAuthenticationFilter.class);
//
//    }
}