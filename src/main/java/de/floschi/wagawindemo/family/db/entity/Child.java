package de.floschi.wagawindemo.family.db.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "child")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Child {

    @Id
    @GeneratedValue
    @Column(name = "child_id")
    private Long childId;

    @ManyToOne
    private Person parent;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @ManyToMany
    @JoinTable(
            name = "child_meal",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private Set<Meal> favMeals;
}
