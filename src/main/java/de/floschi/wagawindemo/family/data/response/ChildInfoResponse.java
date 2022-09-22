package de.floschi.wagawindemo.family.data.response;

import de.floschi.wagawindemo.family.data.dto.MealDto;
import de.floschi.wagawindemo.family.data.dto.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.Set;

@Data
@AllArgsConstructor
public class ChildInfoResponse implements Serializable {


    private PersonDto parent;
    private Set<MealDto> favoriteMeal;

}
