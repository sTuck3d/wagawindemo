package de.floschi.wagawindemo.children.db.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(exclude = "children")
@ToString(exclude = "children")
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

    @OneToMany
    @JoinColumn(name = "parent_person_id")
    private List<Child> children;
}
