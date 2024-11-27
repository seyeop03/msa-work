package com.green.userservice.user.jpa;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(unique = true, nullable = false,length = 50)
    private String email;

    @Setter
    @Column(unique = true, nullable = false)
    private String uuid;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false,length = 100)
    private String password;

    private String thumbnail;

    private User(String email, String uuid, String name, String password, String thumbnail) {
        this.email = email;
        this.uuid = uuid;
        this.name = name;
        this.password = password;
        this.thumbnail = thumbnail;
    }

    public static User of(String email, String uuid, String name, String password, String thumbnail) {
        return new User(email, uuid, name, password, thumbnail);
    }
}
