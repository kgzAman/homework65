package com.amanee.shope.Entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString
@Builder
@Table(name="clients")
public class Client extends baseEntity {

    @NotBlank
    @Size(min = 5)
    @Column(length = 128)
    private String name;

    @NotBlank
    @Column(length = 224)
    private String address;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;


}
