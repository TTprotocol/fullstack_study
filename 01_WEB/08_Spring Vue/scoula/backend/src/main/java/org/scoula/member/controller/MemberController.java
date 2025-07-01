package org.scoula.member.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.scoula.common.util.UploadFiles;
import org.scoula.member.dto.ChangePasswordDTO;
import org.scoula.member.dto.MemberDTO;
import org.scoula.member.dto.MemberJoinDTO;
import org.scoula.member.dto.MemberUpdateDTO;
import org.scoula.member.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;

@Log4j2
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/member")  // 전체 URI prefix
public class MemberController {
    final MemberService service;

    // 아이디 중복 체크 (GET /api/member./checkusername/{username})
    @GetMapping("/checkusername/{username}")
    public ResponseEntity<Boolean> checkUsername(@PathVariable String username) {
        return ResponseEntity.ok().body(service.checkDuplicate(username));
    }

    // 회원가입 (POST /api/member)
    @PostMapping("")
    public ResponseEntity<MemberDTO> join(MemberJoinDTO member) {
        return ResponseEntity.ok(service.join(member));
    }

    // 아바타 이미지 조회
    @GetMapping("/{username}/avatar")
    public void getAvatar(@PathVariable String username, HttpServletResponse response) {
        String avatarPath = "c:/upload/avatar/" + username + ".png";    // 받아온 유저명으로 경로 설정
        File file = new File(avatarPath);

        if (!file.exists()) { // 아바타 등록이 없는 경우, 디폴트 아바타 이미지 사용
            file = new File("C:/upload/avatar/unknown.png");
        }

        // 이미지 파일 응답 전송
        UploadFiles.downloadImage(response, file);
    }

    // 회원 정보 수정
    @PutMapping("/{username}")
    public ResponseEntity<MemberDTO> changeProfile(MemberUpdateDTO member) {

        return ResponseEntity.ok(service.update(member));
    }

    // 패스워드 변경
    @PutMapping("/{username}/changepassword")
    public ResponseEntity<?> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
        service.changePassword(changePasswordDTO);
        return ResponseEntity.ok().build();
    }
}