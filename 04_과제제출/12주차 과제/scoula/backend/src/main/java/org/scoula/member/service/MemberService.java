package org.scoula.member.service;

import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;

public interface MemberService {
    boolean checkDuplicate(String username);    // 아이디 중복 여부 확인

    MemberDTO get(String username); // username으로 회원 정보 조회

    MemberDTO join(MemberJoinDTO member);   // 회원가입 (DTO -> VO -> DB 저장 -> DTO 반환)

    MemberDTO update(MemberUpdateDTO member);   // 회원정보 업데이트, 수정된 회원 정보를 DTO로 변환하는 메서드

    void changePassword(ChangePasswordDTO changePassword);  //
}
