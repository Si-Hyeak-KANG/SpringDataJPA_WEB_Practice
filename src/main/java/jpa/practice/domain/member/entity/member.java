package jpa.practice.domain.member.entity;

import jpa.practice.audit.Auditable;
import jpa.practice.domain.order.entity.Order;
import jpa.practice.domain.stamp.Stamp;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class member extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 13, unique = true)
    private String phone;

    @Enumerated(value = EnumType.STRING)
    private MemberStatus memberStatus = MemberStatus.MEMBER_ACTIVE;

    @OneToOne(mappedBy = "member")
    private Stamp stamp;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    // JPA 연관 메서드
    public void setStamp(Stamp stamp) {
        this.stamp = stamp;

        if(stamp.getMember() != this) {
            stamp.setMember(this);
        }
    }

    public void setOrders(Order order) {
        this.orders.add(order);

        if(order.getMember() != this) {
            order.setMember(this);
        }
    }
}
