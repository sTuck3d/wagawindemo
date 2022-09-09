package de.floschi.wagawindemo.family.data.response;

import lombok.Data;

@Data
public class HouseResponse {

    private long id;
    private String address;
    private int zipCode;
    private String type;
}
