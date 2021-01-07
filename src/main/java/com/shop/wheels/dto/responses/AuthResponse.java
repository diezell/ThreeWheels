package com.shop.wheels.dto.responses;

import lombok.*;

/**
 * Тело ответа аутентификации
 */
@Data
@AllArgsConstructor
public class AuthResponse {

    private String accessToken;

    private String refreshToken;

}