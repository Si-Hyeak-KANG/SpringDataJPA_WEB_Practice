package jpa.practice.domain.member.repository;

import jpa.practice.domain.member.entity.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(long memberId);
    List<Member> findAll();
    void delete(long memberId);

    Optional<Member> findByEmail(String email);
}
