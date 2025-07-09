package kr.study.securitydemo.service;

import kr.study.securitydemo.domain.Member;
import kr.study.securitydemo.repository.MemberRepository;
import kr.study.securitydemo.type.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface MemberService {

    Long createUser(Member user);

    @Service
    @Slf4j
    class Default implements MemberService, UserDetailsService {
        @Autowired
        private MemberRepository memberRepository;

        @Override
        @Transactional(readOnly = true)
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Optional<Member> memberOptional = memberRepository.findByUsername(username);

            if (memberOptional.isPresent()) {
                Member member = memberOptional.get();
                return User.builder()
                        .username(member.getUsername())
                        .password(member.getPassword())
                        .roles(member.getRoles().stream().map(Role::name).toArray(String[]::new))
                        .build();

            } else {
                throw new UsernameNotFoundException(username);
            }
        }

        @Override
        @Transactional
        public Long createUser(Member user) {
            return memberRepository.save(user).getId();
        }
    }
}