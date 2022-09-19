package de.floschi.wagawindemo.family.data;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class HouseDto implements Serializable {

    private Long id;
    private String address;
    private String zipCode;
    private HouseType type;
}
