package jpa.practice.domain.member.controller;

import jpa.practice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Validated
@Slf4j
@RequestMapping("/jpa/practice/member")
public class MemberController {

    private final MemberService memberService;

}
