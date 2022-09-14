package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.PersonDto;
import de.floschi.wagawindemo.family.data.mapper.PersonDtoMapper;
import de.floschi.wagawindemo.family.data.requests.PersonRequestDto;
import de.floschi.wagawindemo.family.db.dao.PersonRepo;
import de.floschi.wagawindemo.family.db.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

import static java.util.Objects.isNull;

@Service
@Transactional
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    private HouseService houseService;

    @Autowired
    private PersonDtoMapper personDtoMapper;

    public PersonDto getPerson(Long personId) {
        Optional<Person> person = personRepo.findById(personId);
        return person.map(p -> personDtoMapper.personToPersonDto(p))
                .orElse(null);
    }

    public PersonDto savePerson(PersonRequestDto personRequestDto) {
        if (isNull(personRequestDto)) {
            // TODO: Mit Validator lösen oder ExceptionHandler einbauen
            throw new IllegalArgumentException();
        }
        var person = personDtoMapper.personRequestDtoToPerson(personRequestDto);
        var newPerson = personRepo.save(person);
        houseService.saveHouse(personRequestDto.getHouse(), newPerson);
        return personDtoMapper.personToPersonDto(newPerson);
    }

}
