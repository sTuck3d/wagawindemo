package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Table(name = "person")
@Data
public class Person {

    @Id
    @GeneratedValue
    @Column(name = "person_id")
    private Long personId;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private int age;

    @OneToOne
    @JoinColumn(name = "house_id", referencedColumnName = "house_id")
    private House house;

    @OneToMany(mappedBy = "parent")
    private List<Child> children;
}
