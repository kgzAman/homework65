package com.amanee.shope.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
public class BathOrder extends BaseEntity {

    @ManyToOne
    private User user;

    @OneToMany
    private List <Product> productList;
}

