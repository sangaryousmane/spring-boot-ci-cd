package com.example.demo.user.utils.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import java.time.ZonedDateTime;

@RequiredArgsConstructor
@Getter
@Setter
public class UserException {
    private final String name;
    private final ZonedDateTime zonedDateTime;
    private final HttpStatus httpStatus;



    @Override
    public String toString() {
        return "UserException{" +
                "name='" + name + '\'' +
                ", zonedDateTime=" + zonedDateTime +
                ", httpStatus=" + httpStatus +
                '}';
    }
}
