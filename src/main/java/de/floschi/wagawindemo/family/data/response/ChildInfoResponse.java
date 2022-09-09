package de.floschi.wagawindemo.family.data.response;

import de.floschi.wagawindemo.family.data.MealDto;
import de.floschi.wagawindemo.family.data.PersonDto;
import lombok.Data;

@Data
public class ChildInfoResponse {

    private PersonDto parent;
    private MealDto favoriteMeal;

}
