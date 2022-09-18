package com.example.demo.domain.user.controller;


import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String email;
    private String password;
}
