package com.shop.wheels.entities.enums;

/**
 * Роли пользователей
 */
public enum Role implements LocalizedEnum {

    USER("Пользователь"), MANAGER("Менеджер"), MODERATOR("Модератор"), ADMIN("Администратор");

    private final String text;

    Role(String text) {
        this.text = text;
    }

    @Override
    public String getLocalizedText() {
        return text;
    }

}