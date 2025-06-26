package org.scoula.controller;

import lombok.extern.log4j.Log4j2;
import org.scoula.security.account.domain.CustomUser;
import org.scoula.security.account.domain.MemberVO;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@Log4j2
//@RequestMapping("/security")
//@Controller
@RequestMapping("/api/security")
@RestController
public class SecurityController {
    @GetMapping("/all")
    public ResponseEntity<String> doAll() {
        log.info("do all can access everybody");
        return ResponseEntity.ok("All can access everybody");
    }

    // 사용자 정보 얻기 1. Principal 사용
//    @GetMapping("/member")
//    public void doMember(Principal principal) {
//        log.info("logined member");
//        log.info("username = " + principal.getName());
//    }

    // 사용자 정보 얻기 2. Authentication 주입
    // Authentication 객체 전체 접근 가능
    @GetMapping("/member")
    public ResponseEntity<String> doMember(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        log.info("username = " + userDetails.getUsername());
        return ResponseEntity.ok(userDetails.getUsername());
    }

    // 사용자 정보 얻기 3. @AuthenticationPrincipal 어노테이션 사용
    // 커스텀 사용자 정보 접근 가능
    @GetMapping("/admin")
    public  ResponseEntity<MemberVO> doAdmin(@AuthenticationPrincipal CustomUser customUser) {
        MemberVO member = customUser.getMember();
        log.info("admin only");
        log.info("username = " + member);
        return ResponseEntity.ok(member);
    }

    //
    @GetMapping("/login")
    public void login() {
        log.info("login page");
    }

    @GetMapping("/logout")
    public void logout() {
        log.info("logout page");
    }
}
