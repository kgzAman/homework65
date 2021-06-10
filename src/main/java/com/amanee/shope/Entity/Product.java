package com.amanee.shope.Entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product extends baseEntity {
//
//    @Column(name ="name",length = 128)
//    private String name;
//
//    @Column(name ="description",length = 224)
//    private String description;
//
//    @Column(name ="price")
//    private BigDecimal price;
//
//    @Column(name ="amount")
//    private int amount;
//
//    @Column(name = "image")
//    private String img;
//
//
//    @Enumerated(EnumType.STRING)
//    @Column(name="types")
//    private Type type;

}
