package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.dto.HouseDto;
import de.floschi.wagawindemo.family.data.response.HouseResponse;
import de.floschi.wagawindemo.family.db.entity.House;
import de.floschi.wagawindemo.family.db.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

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

    @Mapping(source = "houseId", target = "id")
    public abstract HouseDto toHouseDto(House house);

    @Mapping(source = "houseId", target = "id")
    public abstract HouseResponse toHouseResponse(House house);

}
