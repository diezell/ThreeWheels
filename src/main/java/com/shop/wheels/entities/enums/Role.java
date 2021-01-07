package com.shop.wheels.entities.enums;

/**
 * Роли пользователей
 */
public enum Role implements LocalizedEnum {

    USER("Неаккредитованный поставщик"), ADMIN("Администратор"), PRODUCER("Поставщик"), BAD("Добавленный в ЧС");

    private final String text;

    Role(String text) {
        this.text = text;
    }

    @Override
    public String getLocalizedText() {
        return text;
    }

}