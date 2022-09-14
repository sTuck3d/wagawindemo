package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.PersonDto;
import de.floschi.wagawindemo.family.data.requests.PersonRequestDto;
import de.floschi.wagawindemo.family.db.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoMapper {

    public PersonDto personToPersonDto(Person person) {
        return PersonDto.builder()
                .id(person.getPersonId())
                .age(person.getAge())
                .name(person.getName())
                .build();
    }

    public Person personRequestDtoToPerson(PersonRequestDto personRequest) {
        return Person.builder()
                .age(personRequest.getAge())
                .name(personRequest.getName())
                .build();
    }

}
