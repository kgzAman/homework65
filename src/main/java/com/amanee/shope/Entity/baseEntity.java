package com.amanee.shope.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public class baseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
