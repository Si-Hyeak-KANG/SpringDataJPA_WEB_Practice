package jpa.practice.domain.ordercoffee;

import jpa.practice.audit.Auditable;
import jpa.practice.domain.coffee.entity.Coffee;
import jpa.practice.domain.order.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class OrderCoffee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long OrderCoffeeId;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "ORDER_ID")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "COFFEE_ID")
    private Coffee coffee;

    // JPA 연관 메서드
    public void setOrder(Order order) {
        this.order = order;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }
}
