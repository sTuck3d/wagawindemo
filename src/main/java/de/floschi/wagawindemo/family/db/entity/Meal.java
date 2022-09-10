package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@Table("meal")
@Data
public class Meal {

    @Id
    private Long mealId;

    private String name;

    private LocalDate invented;

}
