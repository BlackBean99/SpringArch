package com.example.demo.domain.user.sevice;


import com.example.demo.domain.user.Account;
import com.example.demo.domain.user.AccountRepository;
import com.example.demo.domain.user.controller.LoginResponseDto;
import com.example.demo.global.common.exception.BadRequestException;
import com.example.demo.global.config.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountService {
    private final PasswordEncoder passwordEncoder;
    private final AccountRepository accountRepository;
    private final JwtProvider jwtProvider;
//   회원가입
    public void signUp(String email, String nickname, String password) {
        isDuplicateEmail(email);
        String encodePassword = passwordEncoder.encode(password);
        Account newAccount = Account.of(email, nickname, password);
        accountRepository.save(newAccount);
    }
// 중복된 이메일 확인
    public void isDuplicateEmail(String email) {
        boolean isDuplicate = accountRepository.existsByEmail(email);
        if(!isDuplicate){
            throw new BadRequestException("이미 존재하는 회원입니다");
        }
    }
//f
    public void logout(String email, String accessToken) {
        jwtProvider.checkRefreshToken(email, accessToken);
    }

    private void checkPassword(String password, String encodePassword) {
        boolean isMatch = passwordEncoder.matches(password, encodePassword);
        if(!isMatch){
            throw new BadRequestException("아이디 혹은 비밀번호를 확인하세요");
        }
    }

    public LoginResponseDto reIssueAccessToken(String email, String refreshToken) {

    }

    public LoginResponseDto login(String email, String Password) {
        Account account = accountRepository
                .findByEmail(email).orElseThrow(() -> new BadRequestException("아이디 혹은 비밀번호를 확인하세요"));
        String accessToken = jwtProvider.createAccessToken(account.getEmail(), account.getRole());
        String refreshToken = jwtProvider.createRefreshToken(account.getEmail(), account.getRole());
        return new LoginResponseDto(accessToken, refreshToken);
    }
}
