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
public class User extends BaseEntity {

    @NotBlank
    @Size(min = 5)
    private String name;

    @NotBlank
    private String address;

    @NotBlank
    @Size(min = 6 )
    private String password;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;


}
