package com.amanee.shope.exeption;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
@Data
public class NotFoundException extends RuntimeException {

}
