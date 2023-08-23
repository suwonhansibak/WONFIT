package com.woori.wonfit.member.member.dto;

import com.woori.wonfit.member.member.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class MemberRegisterRequest {
    private String loginId; // 회원 아이디
    private String password; // 회원 패스워드
    private String email; // 회원 이메일
    private String name; // 회원 이름
    private boolean status; // 회원 상태

    public Member toEntity(String password) {
        return Member.builder()
                .loginId(loginId).password(password)
                .email(email)
                .name(name)
                .status(status)
                .build();
    }
}