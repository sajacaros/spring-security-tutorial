package kr.study.securitydemo;

import jakarta.annotation.PostConstruct;
import kr.study.securitydemo.domain.Member;
import kr.study.securitydemo.service.MemberService;
import kr.study.securitydemo.type.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@Slf4j
public class SecurityDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }

    @Autowired
    MemberService memberService;

    @PostConstruct
    public void init() {
        Member user = new Member();
        user.setUsername("user");
        user.setPassword("{noop}123");
        user.setRoles(List.of(Role.USER));

        Member admin = new Member();
        admin.setUsername("admin");
        admin.setPassword("{noop}123");
        admin.setRoles(List.of(Role.ADMIN));

        Long userId  = memberService.createUser(user);
        log.info("User created: {}", userId);
        Long adminId = memberService.createUser(admin);
        log.info("Admin created: {}", adminId);

    }

}
