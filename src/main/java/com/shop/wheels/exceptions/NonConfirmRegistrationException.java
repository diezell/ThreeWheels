package com.shop.wheels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение, когда регистрация пользователя неподтверждена
 */
public class NonConfirmRegistrationException extends ApplicationException {

}