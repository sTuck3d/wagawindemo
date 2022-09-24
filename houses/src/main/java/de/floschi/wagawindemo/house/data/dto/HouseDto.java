package de.floschi.wagawindemo.house.data.dto;

import de.floschi.wagawindemo.house.db.enums.HouseType;
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
