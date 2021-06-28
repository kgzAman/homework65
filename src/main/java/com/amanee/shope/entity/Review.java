package com.amanee.shope.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review extends BaseEntity {
    @OneToOne
    private User user;

    @ManyToOne
    private Order orderForReview;

    private String reviewContent;

    private LocalDateTime localDateTime;

    @Enumerated(EnumType.STRING)
    private Rating rating;

}
