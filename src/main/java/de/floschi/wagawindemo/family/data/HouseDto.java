package de.floschi.wagawindemo.family.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HouseDto {

    private Long id;
    private String address;
    private String zipCode;
    private HouseType type;
}
