package jpa.practice.domain.member.controller;

import jpa.practice.domain.member.dto.MemberPostDto;
import jpa.practice.domain.member.mapper.MemberMapper;
import jpa.practice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/prac/members")
@Validated
@Slf4j
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;

    // postMember
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto post ) {

    }
    // patchMember
    // getMember
    // getMembers
    // deleteMember


}
