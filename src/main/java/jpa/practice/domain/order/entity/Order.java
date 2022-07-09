package jpa.practice.domain.order.entity;

import jpa.practice.audit.Auditable;
import jpa.practice.domain.member.entity.Member;
import jpa.practice.domain.ordercoffee.OrderCoffee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity(name = "ORDERS")
public class Order extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @Enumerated(EnumType.STRING)
    private OrderStates orderStates;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderCoffee> orderCoffees = new ArrayList<>();

    // JPA 연관 메서드
    public void setMember(Member member) {
        this.member = member;
    }

    public void setOrderCoffee(OrderCoffee orderCoffee) {
        this.orderCoffees.add(orderCoffee);

        if(orderCoffee.getOrder() != this) {
            orderCoffee.setOrder(this);
        }
    }
}
