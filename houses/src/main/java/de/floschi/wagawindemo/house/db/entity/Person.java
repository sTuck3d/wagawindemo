package de.floschi.wagawindemo.house.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "person")
@Data
@EqualsAndHashCode(exclude = "house")
@ToString(exclude = "house")
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
    private House house;
}
