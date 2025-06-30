package org.scoula.member.service;

import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;

public interface MemberService {
    boolean checkDuplicate(String username);    // 아이디 중복 여부 확인

    MemberDTO get(String username); // username으로 회원 정보 조회

    MemberDTO join(MemberJoinDTO member);   // 회원가입 (DTO -> VO -> DB 저장 -> DTO 반환)
}
