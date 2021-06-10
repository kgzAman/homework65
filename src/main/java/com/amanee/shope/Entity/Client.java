package com.amanee.shope.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="clients")
public class Client extends baseEntity {

    @Column(length = 128)
    private String name;

    @Column(length = 224)
    private String address;

    @Column(unique = true)
    private String email;


}
