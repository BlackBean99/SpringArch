package com.example.demo.domain.user.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignUpRequestDto {
    private String email;
    private String nickname;
    private String password;
}
