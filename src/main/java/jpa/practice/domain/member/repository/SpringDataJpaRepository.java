package jpa.practice.domain.member.repository;

import jpa.practice.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaRepository extends MemberRepository, JpaRepository<Member,Long> {

}
