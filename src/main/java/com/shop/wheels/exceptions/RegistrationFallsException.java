package com.shop.wheels.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Исключение, когда код подтверждения регистрации не прошёл проверку
 */
@ResponseStatus(code = HttpStatus.NOT_ACCEPTABLE)
public class RegistrationFallsException extends ApplicationException {

}