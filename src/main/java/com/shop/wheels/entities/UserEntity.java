package com.shop.wheels.entities;

import com.shop.wheels.entities.enums.Role;
import lombok.Data;
import javax.persistence.*;
import java.util.*;

/**
 * Сущность пользователя
 */
@Entity
@Table(name = "user_table")
@Data
public class UserEntity {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(name = "confirm_code")
    private UUID confirmCode;

    @OneToMany(mappedBy = "user")
    private List<RefreshTokenEntity> refreshTokens;

}