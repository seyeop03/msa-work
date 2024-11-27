package com.green.orderservice.order.vo;

import com.green.orderservice.order.jpa.Order;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {

    private String email;
    private String name;

    public static OrderResponse from(Order entity){
        return new OrderResponse(entity.getEmail(), entity.getName());
    }
}
