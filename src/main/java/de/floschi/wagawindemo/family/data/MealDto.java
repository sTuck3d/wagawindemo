package de.floschi.wagawindemo.family.data;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MealDto {

    private long id;
    private String name;
    private LocalDate invented;

}
