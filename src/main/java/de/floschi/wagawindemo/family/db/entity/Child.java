package de.floschi.wagawindemo.family.db.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Table;

@Table(name = "child")
@Data
public class Child {

    @Id
    private Long childId;

    private String name;

    private int age;
}
