package jpa.practice.domain.member.service;

import jpa.practice.domain.member.entity.Member;

import java.util.List;

public interface MemberService {

    /**
     * 회원가입
     */
    public Member createMember(Member member);

    /**
     * 회원 정보 수정
     */
    public Member updateMember(Member member);

    /**
     * 회원 조회
     */
    public Member findMember(long memberId);

    /**
     * 회원 전체 조회
     */
    public List<Member> findMembers();

    /**
     * 회원 삭제
     */
    public void deleteMember(long memberId);
}
