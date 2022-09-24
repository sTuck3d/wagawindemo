package de.floschi.wagawindemo.children.db.entity;

import de.floschi.wagawindemo.children.db.enums.ChildType;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "child")
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(exclude = "favMeals")
@ToString(exclude = "favMeals")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "child_id")
    private Long childId;

    @ManyToOne
    private Person parent;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private ChildType type;

    @Column(name = "fav_color")
    private String favColor;

    @ManyToMany
    @JoinTable(
            name = "child_meal",
            joinColumns = @JoinColumn(name = "child_id"),
            inverseJoinColumns = @JoinColumn(name = "meal_id"))
    private Set<Meal> favMeals;
}
