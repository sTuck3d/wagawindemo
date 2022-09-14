package de.floschi.wagawindemo.family.data.response;

import de.floschi.wagawindemo.family.data.HouseType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HouseResponse {

    private long id;
    private String address;
    private String zipCode;
    private HouseType type;
}
