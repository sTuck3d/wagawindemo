package de.floschi.wagawindemo.house.data.mapper;

import de.floschi.wagawindemo.house.data.dto.HouseDto;
import de.floschi.wagawindemo.house.data.response.HouseResponse;
import de.floschi.wagawindemo.house.db.entity.House;
import de.floschi.wagawindemo.house.db.entity.Person;
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
