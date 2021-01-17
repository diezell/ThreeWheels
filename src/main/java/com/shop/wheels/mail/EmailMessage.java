package com.shop.wheels.mail;

import lombok.Data;

/**
 * Данные, необходимые для отправки сообщения
 */
@Data
public class EmailMessage {

    private String email;

    private String subject;

    private String text;

}
