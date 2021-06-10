package com.amanee.shope.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="orders")
@Entity
public class Order extends baseEntity {

    @OneToMany
    private List<Product> products;

    @OneToOne
    private Client client;

    private LocalTime localTime;
}
