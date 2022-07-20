package jpa.practice.domain.member.service;

import jpa.practice.domain.member.entity.member;
import org.springframework.data.domain.Page;

public interface MemberService {

    /**
     * 회원가입
     */
    public member createMember(member member);

    /**
     * 회원 정보 수정
     */
    public member updateMember(member member);

    /**
     * 회원 조회
     */
    public member findMember(long memberId);

    /**
     * 회원 전체 조회
     */
    public Page<member> findMembers(int page, int size);

    /**
     * 회원 삭제
     */
    public void deleteMember(long memberId);
}
