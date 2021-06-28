package com.amanee.shope.dto;

import com.amanee.shope.entity.Rating;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReviewsDTO {

    private int  orderFor;

    private String reviewContent;

    private LocalDateTime localDateTime;

    private Rating rating;

}
