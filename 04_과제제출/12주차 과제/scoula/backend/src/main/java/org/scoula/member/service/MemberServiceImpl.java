package org.scoula.member.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.exception.PasswordMissmatchException;
import org.scoula.member.mapper.MemberMapper;
import org.scoula.security.account.domain.AuthVO;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;

@Log4j2
@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    final PasswordEncoder passwordEncoder;
    final MemberMapper mapper;

    // 중복 검사
    @Override
    public boolean checkDuplicate(String username) {
        MemberVO member = mapper.findByUsername(username);
        return member != null ? true : false;
    }

    // 회원 + 권한 정보 조회
    @Override
    public MemberDTO get(String username) {
        MemberVO member = Optional.ofNullable(mapper.get(username))
            .orElseThrow(NoSuchElementException::new);
        return MemberDTO.of(member);
    }

    // 회원 가입 처리
    @Transactional  // 트랜잭션 처리
    @Override
    public MemberDTO join(MemberJoinDTO dto) {
        MemberVO member = dto.toVO();

        member.setPassword(passwordEncoder.encode(member.getPassword())); // 비밀번호 암호화
        mapper.insert(member);  // 회원 정보 삽입

        // 권한 등록
        AuthVO auth = new AuthVO();
        auth.setUsername(member.getUsername());
        auth.setAuth("ROLE_MEMBER");    // 기본 권한 삽입
        mapper.insertAuth(auth);

        // 아바타 저장
        saveAvatar(dto.getAvatar(), member.getUsername());

        // 저장 후 조회하여 DTO 반환
        return get(member.getUsername());
    }

    // 아바타 파일 저장
    private void saveAvatar(MultipartFile avatar, String username) {
        //아바타 업로드
        if (avatar != null && !avatar.isEmpty()) {
            File dest = new File("c:/upload/avatar", username + ".png");
            try {
                avatar.transferTo(dest);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    // 회원정보 수정
    @Override public MemberDTO update(MemberUpdateDTO member) {
        // DB에서 회원정보 조회
        MemberVO vo = mapper.get(member.getUsername());
        
        // 입력된 비밀번호가 기존 비밀번호와 일치하는지 확인
        if (!passwordEncoder.matches(member.getPassword(), vo.getPassword())) {
            throw new PasswordMissmatchException(); // 불일치 시 예외 발생
        }
        
        // 회원 정보 업데이트
        mapper.update(member.toVO());
        saveAvatar(member.getAvatar(), member.getUsername());
        return get(member.getUsername());
    }

    // 비밀번호 변경
    @Override public void changePassword(ChangePasswordDTO changePassword) {
        MemberVO member = mapper.get(changePassword.getUsername());
        if (!passwordEncoder.matches(changePassword.getOldPassword(), member.getPassword())) {
            throw new PasswordMissmatchException();
        }
        changePassword.setNewPassword(passwordEncoder.encode(changePassword.getNewPassword()));
        mapper.updatePassword(changePassword);
    }
}
