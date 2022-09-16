package de.floschi.wagawindemo.family.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildBicycleColorResponse implements ChildColorResponse {

    private String bicycleColor;
}
