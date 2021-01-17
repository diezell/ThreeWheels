package com.shop.wheels.controllers;

import com.shop.wheels.dto.requests.*;
import com.shop.wheels.dto.responses.AuthResponse;
import com.shop.wheels.exceptions.*;
import com.shop.wheels.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

/**
 * Контроллер регистрации и аутентификации
 */
@RestController
public class AuthController {

    private final RegistrationService registrationService;

    private final AuthService authService;

    /**
     * Конструктор контроллера
     */
    @Autowired
    public AuthController(RegistrationService registrationService, AuthService authService) {
        this.registrationService = registrationService;
        this.authService = authService;
    }

    /**
     * POST-запрос на регистрацию пользователя
     */
    @PostMapping("/register")
    public void registerUser(@RequestBody @Valid RegistrationRequest request) throws UniqueException {
        registrationService.saveUser(request);
    }

//    /**
//     * PUT-запрос на смену пароля
//     * @param id - id пользователя
//     * @param request - запрос с новым паролем
//     */
//    @PutMapping("/user/{id}/newpassword")
//    @PreAuthorize("#id.toString() == authentication.principal.username")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void changePassword(@PathVariable("id") UUID id, @RequestBody @Valid ChangePasswordRequest request)
//            throws ResourceNotFoundException, ValidationFallsException {
//        registrationService.changePassword(id, request);
//    }

    /**
     * GET-запрос на подтверждение аккаунта
     * @param code - личный номер пользователя
     */
    @GetMapping("/confirm/{code}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void activate(@PathVariable UUID code) throws RegistrationFallsException {
        registrationService.activateUser(code);
    }

    /**
     * POST-запрос на аутентификацию
     * @param authRequest - тело запроса с логином и паролем
     * @return - токены
     */
    @PostMapping("/auth")
    public AuthResponse auth(@Valid @RequestBody AuthRequest authRequest) throws ApplicationException {
        return authService.giveTokensByPassword(authRequest);
    }

    /**
     * Обновляет токены по рефреш-токену
     * @param refreshRequest рефреш-токен и фингерпринт
     * @return токены
     */
    @PostMapping("/refresh")
    public AuthResponse refresh(@Valid @RequestBody RefreshRequest refreshRequest) throws AuthWrongException {
        return authService.giveTokensByRefreshToken(refreshRequest);
    }

}