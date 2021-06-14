package com.amanee.shope.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends baseEntity {

    @NotBlank
    @Size(min = 4)
    @Column(name ="name",length = 128)
    private String name;
    @NotBlank
    @Size(min = 10)
    @Column(name ="description",length = 224)
    private String description;

    @Positive
    @Column(name ="price")
    private BigDecimal price;

    @NotBlank
    @PositiveOrZero
    @Column(name ="amount")
    private int amount;

    @NotBlank
    @Column(name = "image")
    private String img;


    @Enumerated(EnumType.STRING)
    @Column(name="types")
    private Type type;

}
