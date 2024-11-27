package com.green.orderservice.order.jpa;

import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
@Entity
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String email;

    @Column(unique = true, nullable = false)
    private String userId;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false,length = 100)
    private String password;

    private String thumbnail;

    private Order(String email, String userId, String name, String password, String thumbnail) {
        this.email = email;
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.thumbnail = thumbnail;
    }

    public static Order of(String email, String userId, String name, String password, String thumbnail) {
        return new Order(email, userId, name, password, thumbnail);
    }
}
