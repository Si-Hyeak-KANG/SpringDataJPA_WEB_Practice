package jpa.practice.domain.member.repository;

import jpa.practice.domain.member.entity.member;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface MemberRepository {

    member save(member member);
    Optional<member> findById(long memberId);
    Page<member> findAll(Pageable pageable);
    void delete(member member);

    Optional<member> findByEmail(String email);
}
