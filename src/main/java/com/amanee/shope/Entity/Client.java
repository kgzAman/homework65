package com.amanee.shope.Entity;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
