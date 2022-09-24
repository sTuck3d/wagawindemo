package de.floschi.wagawindemo.children.data.mapper;

import de.floschi.wagawindemo.children.data.response.ChildInfoResponse;
import de.floschi.wagawindemo.children.db.entity.Child;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {MealDtoMapper.class, PersonDtoMapper.class})
public abstract class ChildDtoMapper {

    @Mapping(source = "favMeals", target = "favoriteMeal")
    public abstract ChildInfoResponse childToChildInfoResponse(Child child);

}
