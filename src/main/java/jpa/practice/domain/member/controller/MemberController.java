package jpa.practice.domain.member.controller;

import jpa.practice.domain.member.dto.MemberPatchDto;
import jpa.practice.domain.member.dto.MemberPostDto;
import jpa.practice.domain.member.dto.MemberResponseDto;
import jpa.practice.domain.member.entity.member;
import jpa.practice.domain.member.mapper.MemberMapper;
import jpa.practice.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

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
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto postDto ) {

        member mappingMember = mapper.memberPostDtoToMember(postDto);
        member newMember = memberService.createMember(mappingMember);
        MemberResponseDto result = mapper.memberToMemberResponse(newMember);
        return new ResponseEntity(result, HttpStatus.CREATED);
    }

    // patchMember
    @PatchMapping("{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive Long memberId,
                                      @Valid @RequestBody MemberPatchDto patchDto){

        patchDto.setMemberId(memberId);

        member mappingMember = mapper.memberPatchDtoToMember(patchDto);
        member updateMEmber = memberService.updateMember(mappingMember);
        MemberResponseDto result = mapper.memberToMemberResponse(updateMEmber);
        return new ResponseEntity(result, HttpStatus.OK);
    }

    // getMember
    @GetMapping("member-id")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {

        member findMember = memberService.findMember(memberId);
        MemberResponseDto result = mapper.memberToMemberResponse(findMember);
        return new ResponseEntity(result,HttpStatus.OK);
    }

    // getMembers
    @GetMapping
    public ResponseEntity getMembers(@RequestParam int page, @RequestParam int size) {

        return null;
    }

    // deleteMember
    @DeleteMapping("{member-id}")
    public ResponseEntity deleteMembers(@PathVariable("member-id") @Positive Long memberId) {
        return null;
    }


}
