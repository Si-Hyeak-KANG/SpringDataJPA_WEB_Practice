package jpa.practice.domain.member.mapper;

import jpa.practice.domain.member.dto.MemberPatchDto;
import jpa.practice.domain.member.dto.MemberPostDto;
import jpa.practice.domain.member.dto.MemberResponseDto;
import jpa.practice.domain.member.entity.member;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MemberMapper {

    member memberPostDtoToMember(MemberPostDto memberPostDto);
    member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
    MemberResponseDto memberToMemberResponse(member member);
    List<MemberResponseDto> membersToMemberResponses(List<member> members);
}
