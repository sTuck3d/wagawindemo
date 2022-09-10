package de.floschi.wagawindemo.family.data.response;

import de.floschi.wagawindemo.family.data.MealDto;
import de.floschi.wagawindemo.family.data.PersonDto;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChildInfoResponse {

    private PersonDto parent;
    private MealDto favoriteMeal;

}
