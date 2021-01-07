package com.shop.wheels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение, если аутентификация прошла неуспешно
 */
@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class AuthWrongException extends ApplicationException {

}