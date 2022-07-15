package jpa.practice.domain.member.controller;

import jpa.practice.domain.member.dto.MemberPatchDto;
import jpa.practice.domain.member.dto.MemberPostDto;
import jpa.practice.domain.member.entity.Member;
import jpa.practice.domain.member.mapper.MemberMapper;
import jpa.practice.domain.member.service.MemberService;
import jpa.practice.domain.stamp.Stamp;
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
@RequiredArgsConstructor
@Validated
@Slf4j
@RequestMapping("/jpa/practice/member")
public class MemberController {

    private final MemberService memberService;
    private final MemberMapper mapper;

    // postMember
    @PostMapping
    public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {

        Member mappingMember = mapper.memberPostDtoToMember(memberDto);
        mappingMember.setStamp(new Stamp());
        Member createMember = memberService.createMember(mappingMember);

        return new ResponseEntity(mapper.memberToMemberResponse(createMember), HttpStatus.CREATED);
    }

    // patchMember
    @PatchMapping("/{member-id}")
    public ResponseEntity patchMember(@PathVariable("member-id") @Positive long memberId,
                                      @Valid @RequestBody MemberPatchDto memberDto) {

        memberDto.setMemberId(memberId);
        Member mappingMember = mapper.memberPatchDtoToMember(memberDto);

        Member updateMember = memberService.updateMember(mappingMember);
        
        return new ResponseEntity(mapper.memberToMemberResponse(updateMember), HttpStatus.OK);
    }

    // getMember
    @GetMapping("/{member-id}")
    public ResponseEntity getMember(@PathVariable("member-id") @Positive long memberId) {
        return null;
    }

    // getMembers
    @GetMapping
    public ResponseEntity getMembers(@Positive @RequestParam int page,
                                     @Positive @RequestParam int size) {
        Page<Member> pageMembers = memberService.findMembers(page - 1, size);
        List<Member> members = pageMembers.getContent();

        return new ResponseEntity(mapper.membersToMemberResponseDtos(members));
    }

    // deleteMember
    @DeleteMapping("/{member-id}")
    public ResponseEntity deleteMember(@PathVariable("member-id") @Positive long memberId) {

        return null;
    }

}
