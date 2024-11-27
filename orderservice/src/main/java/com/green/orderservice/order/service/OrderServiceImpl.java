package com.green.orderservice.order.service;

import com.green.orderservice.error.OrderException;
import com.green.orderservice.order.jpa.Order;
import com.green.orderservice.order.jpa.OrderRepository;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Override
    public void join(OrderRequest orderRequest) {

        String email = orderRequest.getEmail();

        orderRepository.findByEmail(email)
                .ifPresent(user -> {
                    throw new OrderException(String.format("User email %s already exist", email));
                });

        Order entity = orderRequest.toEntity();
        entity.setUserId(UUID.randomUUID().toString());

        orderRepository.save(entity);
    }

    @Override
    public OrderResponse getOrder(Long userId) {

        Order order = orderRepository.findById(userId)
                .orElseThrow(() -> new OrderException(String.format("User id %s not found", userId)));

        return OrderResponse.from(order);
    }
}
