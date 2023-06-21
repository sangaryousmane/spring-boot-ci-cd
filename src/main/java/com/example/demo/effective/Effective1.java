package com.example.demo.effective;

import lombok.Builder;

import java.util.EnumSet;
import java.util.Set;

import static com.example.demo.effective.MONTH.*;

public class Effective1 {


    public static void enumSet() throws Exception {
        Set<MONTH> months = EnumSet.of(JUNE, JULY, APRIL, MAY, FEBRUARY);

        if (months.contains(DECEMBER)) {
            months.remove(DECEMBER);
        } else {
            throw new Exception("Enum not found");
        }
    }
}


enum MONTH {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY,
    JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER,
    NOVEMBER, DECEMBER
}
