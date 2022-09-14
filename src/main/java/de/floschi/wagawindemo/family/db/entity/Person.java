package de.floschi.wagawindemo.family.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(exclude = {"children", "house"})
@ToString(exclude = {"children", "house"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "house_id", referencedColumnName = "house_id")
    private House house;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
}
