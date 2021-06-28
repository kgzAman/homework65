package com.amanee.shope.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@Entity
public class Order extends BaseEntity {

    @OneToMany
    private List<Product> products;

    @OneToOne
    private User client;

    @DateTimeFormat
    private LocalTime localTime;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Review> review;
}
