package de.floschi.wagawindemo.family.data.requests;

import de.floschi.wagawindemo.family.data.dto.HouseDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class PersonRequestDto implements Serializable {

    private String name;
    private int age;

    private HouseDto house;
}
