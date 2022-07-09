package jpa.practice.domain.coffee.entity;

import jpa.practice.audit.Auditable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Coffee extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long coffeeId;

    @Column(length = 100, nullable = false)
    private String korName;

    @Column(length = 100, nullable = false)
    private String engName;

    @Column(length = 5, nullable = false)
    private int price;

    @Column(length = 3, nullable = false, unique = true)
    private String coffeeCode;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private CoffeeStatus coffeeStatus;
}