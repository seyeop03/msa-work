package com.green.orderservice.order;


import com.green.orderservice.order.service.OrderService;
import com.green.orderservice.order.vo.OrderRequest;
import com.green.orderservice.order.vo.OrderResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("join")
    public ResponseEntity<?> joinUser(@Valid @RequestBody OrderRequest orderRequest) {

        orderService.join(orderRequest);
        return ResponseEntity.ok(null);
    }

    @GetMapping("login/{user-id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable("order-id") Long orderId) {
        OrderResponse orderResponse = orderService.getOrder(orderId);
        return ResponseEntity.ok(orderResponse);
    }

    @GetMapping("kakaologin")
    public ResponseEntity<String> getKakaoLogin() {
        return ResponseEntity.ok(null);
    }
}
