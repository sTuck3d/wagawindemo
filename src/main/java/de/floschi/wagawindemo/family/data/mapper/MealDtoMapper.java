package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.dto.MealDto;
import de.floschi.wagawindemo.family.db.entity.Meal;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface MealDtoMapper {
    String MEAL_TO_DTO_MAPPING = "mealToDtoMapping";

    @Named(MEAL_TO_DTO_MAPPING)
    @Mapping(source = "mealId", target = "id")
    MealDto mealToMealDto(Meal meal);

    @IterableMapping(qualifiedByName = MEAL_TO_DTO_MAPPING)
    Set<MealDto> mealListToMealDto(Set<Meal> meal);
}
