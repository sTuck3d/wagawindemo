package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("child")
@Data
public class Child {

    @Id
    private Long childId;

    private String name;

    private int age;
}
