package de.floschi.wagawindemo.family.data;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class PersonDto implements Serializable {

    private Long id;
    private String name;
    private int age;
}
