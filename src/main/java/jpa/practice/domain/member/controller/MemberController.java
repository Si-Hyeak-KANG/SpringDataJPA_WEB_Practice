package jpa.practice.domain.member.controller;

import jpa.practice.domain.member.dto.MemberPatchDto;
import jpa.practice.domain.member.dto.MemberPostDto;
import jpa.practice.domain.member.dto.MemberResponseDto;
import jpa.practice.domain.member.entity.Member;
import jpa.practice.domain.member.mapper.MemberMapper;
import jpa.practice.domain.member.service.MemberService;
import jpa.practice.domain.stamp.Stamp;
import jpa.practice.response.MultiResponseDto;
import jpa.practice.response.SingleResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

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

        Member mappingMember = mapper.memberPostDtoToMember(postDto);
        mappingMember.setStamp(new Stamp());

        Member newMember = memberService.createMember(mappingMember);
        MemberResponseDto result = mapper.memberToMemberResponse(newMember);
        return new ResponseEntity(new SingleResponseDto<>(result), HttpStatus.CREATED);
    }

    // patchMember
    @PatchMapping("{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive Long memberId,
                                      @Valid @RequestBody MemberPatchDto patchDto){

        patchDto.setMemberId(memberId);

        Member mappingMember = mapper.memberPatchDtoToMember(patchDto);
        Member updateMember = memberService.updateMember(mappingMember);
        MemberResponseDto result = mapper.memberToMemberResponse(updateMember);
        return new ResponseEntity(new SingleResponseDto<>(result), HttpStatus.OK);
    }

    // getMember
    @GetMapping("member-id")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive Long memberId) {

        Member findMember = memberService.findMember(memberId);
        MemberResponseDto result = mapper.memberToMemberResponse(findMember);
        return new ResponseEntity<>(new SingleResponseDto<>(result),HttpStatus.OK);
    }

    // getMembers
    @GetMapping
    public ResponseEntity getMembers(@RequestParam @Positive int page,
                                     @RequestParam @Positive int size) {

        Page<Member> findMembers = memberService.findMembers(page - 1, size);
        List<MemberResponseDto> result = mapper.membersToMemberResponses(findMembers.getContent());

        return new ResponseEntity<>(new MultiResponseDto<>(result,findMembers),HttpStatus.OK);
    }

    // deleteMember
    @DeleteMapping("{member-id}")
    public ResponseEntity deleteMembers(@PathVariable("member-id") @Positive Long memberId) {
        memberService.deleteMember(memberId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
