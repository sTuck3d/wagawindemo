package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("person")
@Data
public class Person {

    @Id
    private Long personId;

    private String name;

    private int age;
}
