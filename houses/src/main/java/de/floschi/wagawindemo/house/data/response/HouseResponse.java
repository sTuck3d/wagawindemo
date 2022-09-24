package de.floschi.wagawindemo.house.data.response;

import de.floschi.wagawindemo.house.db.enums.HouseType;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class HouseResponse implements Serializable {

    private long id;
    private String address;
    private String zipCode;
    private HouseType type;
}
