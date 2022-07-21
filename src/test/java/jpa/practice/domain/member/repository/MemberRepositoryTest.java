package jpa.practice.domain.member.repository;

import jpa.practice.domain.member.entity.Member;
import jpa.practice.domain.member.entity.MemberStatus;
import jpa.practice.domain.stamp.Stamp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    static Member stubMember;
    static Member stubMember2;
    static List<Member> stubMembers;

    @BeforeEach
    public void init() {
        stubMember = new Member();
        stubMember.setMemberId(1L);
        stubMember.setEmail("test@test.com");
        stubMember.setName("test");
        stubMember.setPhone("010-1111-1111");
        stubMember.setMemberStatus(MemberStatus.MEMBER_ACTIVE);
        stubMember.setStamp(new Stamp());

        stubMember2 = new Member();
        stubMember2.setMemberId(1L);
        stubMember2.setEmail("test@test.com");
        stubMember2.setName("test");
        stubMember2.setPhone("010-1111-1111");
        stubMember2.setMemberStatus(MemberStatus.MEMBER_ACTIVE);
        stubMember2.setStamp(new Stamp());

        stubMembers = List.of(stubMember,stubMember2);
    }

    @Test
    @DisplayName("회원 추가")
    void save() {
        // given
        // when
        Member savedMember = memberRepository.save(stubMember);

        // then
        assertEquals(savedMember.getEmail(),stubMember.getEmail());
        assertTrue(savedMember.getName().equals(stubMember.getName()));
        assertTrue(savedMember.getPhone().equals(stubMember.getPhone()));
    }

    @Test
    @DisplayName("Id 기반 회원 조회")
    void findById() {
        // given
        Member actualMember = memberRepository.save(stubMember);
        // when
        Member findMember = memberRepository.findById(1L).get();

        // then
        assertThat(findMember, is(equalTo(actualMember)));
    }

    @Test
    @DisplayName("Id 기반 회원 조회 시 결과 : NoSuch")
    void findByIdIsNull() {
        // when
        Optional<Member> findMember = memberRepository.findById(1L);
        // then
        assertTrue(findMember.isEmpty());
    }

    @Test
    @DisplayName("회원 전체 조회")
    void findAll() {
        // given
        memberRepository.save(stubMember);
        memberRepository.save(stubMember2);

        Page<Member> findMembers = memberRepository.findAll(PageRequest.of(0, 10, Sort.by("memberId").descending()));
        List<Member> expected = findMembers.getContent();

        expected.stream().forEach(System.out::println);



    }

    @Test
    @DisplayName("회원 삭제")
    void delete() {
    }

    @Test
    void findByEmail() {

    }
}