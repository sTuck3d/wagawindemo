package de.floschi.wagawindemo.family.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "meal")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Meal {

    @Id
    @GeneratedValue
    private Long mealId;

    @Column(name = "name")
    private String name;

    @Column(name = "invented")
    private LocalDate invented;

    @ManyToMany(mappedBy = "favMeals")
    private Set<Child> children;

}
