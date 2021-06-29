package com.amanee.shope.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bath_order")
public class BathOrder extends BaseEntity {

    @ManyToOne
    private User user;

    @OneToMany
    private List <Product> productList;

}

