package de.floschi.wagawindemo.children.data.mapper;

import de.floschi.wagawindemo.children.data.dto.PersonDto;
import de.floschi.wagawindemo.children.db.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PersonDtoMapper {

    @Mapping(source = "personId", target = "id")
    public abstract PersonDto personToPersonDto(Person person);

}
