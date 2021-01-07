package com.shop.wheels.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.UUID;

/**
 * Сущность категории
 */
@Entity
@Data
public class CategoryEntity {

    @Id
    private UUID id;

    private String name;

}