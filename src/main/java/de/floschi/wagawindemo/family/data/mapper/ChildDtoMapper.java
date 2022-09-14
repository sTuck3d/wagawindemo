package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.response.ChildInfoResponse;
import de.floschi.wagawindemo.family.db.entity.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MealDtoMapper.class, PersonDtoMapper.class})
public abstract class ChildDtoMapper {

    @Mapping(source = "favMeals", target = "favoriteMeal")
    public abstract ChildInfoResponse childToChildInfoResponse(Child child);

}
