package de.floschi.wagawindemo.family.data;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class MealDto implements Serializable {

    private Long id;
    private String name;
    private LocalDate invented;

}
