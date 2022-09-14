package de.floschi.wagawindemo.family.data.requests;

import de.floschi.wagawindemo.family.data.HouseDto;
import lombok.Data;

@Data
public class PersonRequestDto {

    private String name;
    private int age;

    private HouseDto house;
}
