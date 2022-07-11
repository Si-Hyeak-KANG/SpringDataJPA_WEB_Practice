package jpa.practice.domain.member.dto;

import jpa.practice.domain.member.entity.MemberStatus;
import jpa.practice.domain.stamp.Stamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MemberResponseDto {

    private long memberId;
    private String email;
    private String name;
    private String phone;
    private MemberStatus memberStatus;
    private Stamp stamp;
}
