package de.floschi.wagawindemo.family.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {

    private Long id;
    private String name;
    private int age;
}
