package com.shop.wheels.services;

import com.shop.wheels.dto.requests.RegistrationRequest;
import com.shop.wheels.entities.UserEntity;
import com.shop.wheels.entities.enums.Role;
import com.shop.wheels.exceptions.*;
import com.shop.wheels.mail.*;
import com.shop.wheels.repositories.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Сервис регистрации
 */
@Service
@Transactional
public class RegistrationService {

    private final UserRepository userRepository;

    private EmailSender emailSender;

    private PasswordEncoder passwordEncoder;

    @Value("${front.url}")
    private String frontUrl;

    /**
     * Конструктор
     */
    @Autowired
    public RegistrationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Сохранение пользователя(регистрация)
     */
    public void saveUser(RegistrationRequest request) throws UniqueException {
        if (userRepository.findByLogin(request.getLogin()).isPresent()) {
            throw new UniqueException("User with this email already exists");
        }
        UserEntity entity = new UserEntity();
        entity.setId(UUID.randomUUID());
        entity.setConfirmCode(UUID.randomUUID());
        entity.setLogin(request.getLogin());
        entity.setPassword(passwordEncoder.encode(request.getPassword()));
        entity.setFirstName(request.getFirstName());
        entity.setLastName(request.getLastName());
        entity.setRole(Role.USER);
        userRepository.save(entity);

        sendConfirmEmail(entity);
    }

    private void sendConfirmEmail(UserEntity entity) {
        EmailMessage emailMessage = new EmailMessage();
        emailMessage.setEmail(entity.getLogin());
        emailMessage.setText("Добро пожаловать в интернет-магазин \"Три колеса\", для завершения регистрации перейдите по ссылке: " +
                frontUrl + "/confirm/" + entity.getConfirmCode());
        emailMessage.setSubject("Три колеса");
        emailSender.send(emailMessage);
    }

    /**
     * Активация пользователя
     * @param confirmRegistration - личный номер пользователя
     */
    public void activateUser(UUID confirmRegistration) throws RegistrationFallsException {
        UserEntity entity = userRepository.findByConfirmCode(confirmRegistration).orElseThrow(RegistrationFallsException::new);
        entity.setConfirmCode(null);
        userRepository.save(entity);
    }

    /**
     * EmailSender сеттер
     */
    @Autowired
    public void setEmailSender(@Lazy EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    /**
     * PasswordEncoder сеттер
     */
    @Autowired
    public void setPasswordEncoder(@Lazy PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

}