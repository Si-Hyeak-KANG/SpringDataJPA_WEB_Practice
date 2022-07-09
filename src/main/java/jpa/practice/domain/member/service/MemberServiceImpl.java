package jpa.practice.domain.member.service;

import jpa.practice.domain.member.entity.Member;
import jpa.practice.domain.member.repository.MemberRepository;
import jpa.practice.exception.BusinessLogicException;
import jpa.practice.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {

        verifyExistsEmail(member.getEmail());
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member) {
        return null;
    }

    @Override
    public Member findMember(long memberId) {
        return null;
    }

    @Override
    public List<Member> findMembers() {
        return null;
    }

    @Override
    public void deleteMember(long memberId) {

    }

    // 이메일 검증 메서드
    private void verifyExistsEmail(String email) {

        Optional<Member> member = memberRepository.findByEmail(email);

        if(member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }
}
