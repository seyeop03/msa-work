package com.green.orderservice.order.service;

import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OrderService {

    void join(OrderRequest orderRequest);

    OrderResponse getOrder(Long userId);
}
