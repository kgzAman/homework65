package com.amanee.shope.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="clients")
public class User extends BaseEntity {

    @NotBlank
    @Size(min = 5)
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 6 )
    private String password;

    @Column
    @Builder.Default
    private boolean enabled = true;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

}
