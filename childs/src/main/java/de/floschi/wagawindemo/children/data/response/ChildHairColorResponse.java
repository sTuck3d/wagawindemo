package de.floschi.wagawindemo.children.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildHairColorResponse implements ChildColorResponse {

    private String hairColor;
}
