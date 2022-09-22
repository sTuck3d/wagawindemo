package de.floschi.wagawindemo.family.data.dto;

import de.floschi.wagawindemo.family.db.enums.HouseType;
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
