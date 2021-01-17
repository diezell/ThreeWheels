package com.shop.wheels.dto.requests;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.validation.constraints.*;

/**
 * Тело запроса на регистрацию
 */
@Data
public class RegistrationRequest {

    @Email
    @NotBlank
    @Length(min = 6, max = 320)
    private String login;

    @NotBlank
    private String password;

    @NotBlank
    @Length(min = 1, max = 200)
    private String firstName;

    @Length(min = 1, max = 200)
    private String lastName;

}