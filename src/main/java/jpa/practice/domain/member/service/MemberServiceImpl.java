package jpa.practice.domain.member.service;

import jpa.practice.domain.member.entity.Member;
import jpa.practice.domain.member.repository.MemberRepository;
import jpa.practice.exception.BusinessLogicException;
import jpa.practice.exception.ExceptionCode;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());
        return memberRepository.save(member);
    }

    @Override
    public Member updateMember(Member member) {

        Member findMember = findVerifiedMember(member.getMemberId());

        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getPhone())
                .ifPresent(phone -> findMember.setPhone(phone));
        Optional.ofNullable(member.getMemberStatus())
                .ifPresent(status -> findMember.setMemberStatus(status));

        return memberRepository.save(findMember);
    }

    @Override
    public Member findMember(long memberId) {
        return findVerifiedMember(memberId);
    }

    @Override
    public Page<Member> findMembers(int page, int size) {
        return memberRepository.findAll(PageRequest.of(page, size, Sort.by("memberId").descending()));
    }


    @Override
    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    // 이메일 검증 메서드
    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) throw new BusinessLogicException(ExceptionCode.MEMBER_EXISTS);
    }

    // 회원 존재 확인 메서드
    private Member findVerifiedMember(long memberId) {
        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member member = optionalMember.orElseThrow(() ->
                new BusinessLogicException(ExceptionCode.MEMBER_NOT_FOUND));
        return member;
    }
}
