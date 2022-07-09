package jpa.practice.domain.order.entity;

import jpa.practice.audit.Auditable;

public enum OrderStates{

    ORDER_REQUEST(1,"요청"),
    ORDER_CONFIRM(2,"확정"),
    ORDER_COMPLETE(3,"처리완료"),
    ORDER_CANCEL(4,"취소");

    private int step;
    private String states;

    OrderStates(int step, String states) {
        this.step = step;
        this.states = states;
    }
}
