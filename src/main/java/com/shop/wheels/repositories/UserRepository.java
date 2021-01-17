package com.shop.wheels.repositories;

import com.shop.wheels.entities.UserEntity;
import com.shop.wheels.entities.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.*;

/**
 * Репозиторий пользователя
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

    /**
     * Поиск пользователя по логину
     * @param login - логин пользователя
     */
    Optional<UserEntity> findByLogin(String login);

    /**
     * Поиск Пользователя по его личному номеру
     *
     * @param confirmCode - личный номер пользователя
     */
    Optional<UserEntity> findByConfirmCode(UUID confirmCode);

    /**
     * Поиск пользователя по роли
     * @param role - роль пользователя
     */
    Optional<UserEntity> findByRole(Role role);

}