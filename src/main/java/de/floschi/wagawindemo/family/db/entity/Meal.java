package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Table(name = "meal")
@Data
public class Meal {

    @Id
    @GeneratedValue
    private Long mealId;

    @Column(name = "name")
    private String name;

    @Column(name = "invented")
    @Temporal(TemporalType.DATE)
    private LocalDate invented;

    @ManyToMany(mappedBy = "favMeals")
    private Set<Child> children;

}
