package jpa.practice.domain.stamp;

import jpa.practice.audit.Auditable;
import jpa.practice.domain.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Stamp extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stampId;

    private int stampCount;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    // JPA 연관 메서드
    public void setMember(Member member) {
        this.member = member;
    }
}
