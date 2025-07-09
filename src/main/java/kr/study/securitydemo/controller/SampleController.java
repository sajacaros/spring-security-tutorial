package kr.study.securitydemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SampleController {
    @GetMapping("/")
    public String index(Principal principal) {
        if(principal == null) {
            return "Hello, Spring Security";
        } else {
            return "Welcome " + principal.getName();
        }
    }

    @GetMapping("/info")
    public String info() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "information page" + auth.getName();
    }

    @GetMapping("/dashboard")
    public String dashboard(Principal principal) {
        return "Hi,  " + principal.getName();
    }
}
