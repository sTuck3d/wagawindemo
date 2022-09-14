package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.HouseDto;
import de.floschi.wagawindemo.family.data.response.HouseResponse;
import de.floschi.wagawindemo.family.db.entity.House;
import de.floschi.wagawindemo.family.db.entity.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class HouseDtoMapper {

    public House toHouseEntity(HouseDto houseDto, Person personEntity) {
        return House.builder()
                .address(houseDto.getAddress())
                .zipCode(houseDto.getZipCode())
                .type(houseDto.getType())
                .person(personEntity)
                .build();
    }

    public abstract HouseDto toHouseDto(House house);

    public abstract HouseResponse toHouseResponse(House house);

}
