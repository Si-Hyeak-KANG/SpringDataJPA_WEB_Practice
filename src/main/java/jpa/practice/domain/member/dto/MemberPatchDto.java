package jpa.practice.domain.member.dto;

import jpa.practice.domain.member.entity.MemberStatus;
import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
public class MemberPatchDto {

    private long memberId;

    @NotBlank
    private String name;

    @Pattern(regexp = "^010-\\d{3,4}-\\d{4}$",
            message = "휴대폰 번호는 010으로 시작하는 11자리 숫자와 '-'로 구성되어야 합니다.")
    @NotBlank
    private String phone;

    @NotBlank
    private MemberStatus memberStatus;

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }
}
