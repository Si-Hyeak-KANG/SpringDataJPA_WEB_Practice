package jpa.practice.domain.member.repository;

import jpa.practice.domain.member.entity.Member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(long memberId);
    Page<Member> findAll(Pageable pageable);
    void delete(Member member);

    Optional<Member> findByEmail(String email);
}
