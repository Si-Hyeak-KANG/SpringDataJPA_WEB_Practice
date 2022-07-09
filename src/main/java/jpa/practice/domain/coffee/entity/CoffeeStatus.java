package jpa.practice.domain.coffee.entity;

public enum CoffeeStatus {

    COFFEE_FOR_SALE("판매중"),
    COFFEE_SOLD_OUT("판매중지");

    private String status;

    CoffeeStatus(String status) {
        this.status = status;
    }
}
