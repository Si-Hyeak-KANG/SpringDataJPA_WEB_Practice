package jpa.practice.domain.member.mapper;

import jpa.practice.domain.member.dto.MemberPatchDto;
import jpa.practice.domain.member.dto.MemberPostDto;
import jpa.practice.domain.member.dto.MemberResponseDto;
import jpa.practice.domain.member.entity.Member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    Member memberPostDtoToMember(MemberPostDto memberPostDto);
    Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponse(Member member);
    List<MemberResponseDto> membersToMemberResponses(List<Member> members);
}
