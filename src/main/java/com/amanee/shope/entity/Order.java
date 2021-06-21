package com.amanee.shope.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@Entity
public class Order extends BaseEntity {

    @OneToMany
    private List<Product> products;


    @OneToOne
    private User client;
    @DateTimeFormat
    private LocalTime localTime;
}
