package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.dto.PersonDto;
import de.floschi.wagawindemo.family.data.requests.PersonRequestDto;
import de.floschi.wagawindemo.family.db.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class PersonDtoMapper {

    @Mapping(source = "personId", target = "id")
    public abstract PersonDto personToPersonDto(Person person);

    public abstract Person personRequestDtoToPerson(PersonRequestDto personRequest);

}
