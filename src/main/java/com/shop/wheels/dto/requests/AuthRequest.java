package com.shop.wheels.dto.requests;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;

/**
 * Тело запроса аутентификации
 */
@Data
public class AuthRequest {

    @NotBlank
    @Email
    @Length(min = 6, max = 320)
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    private String fingerprint;

}