package com.shop.wheels.security.jwt;

import com.shop.wheels.entities.enums.Role;
import lombok.*;

/**
 * Информация, заносимая в access token
 */
@Data
@AllArgsConstructor
public class TokenInformation {

    private String userId;

    private Role role;

}
