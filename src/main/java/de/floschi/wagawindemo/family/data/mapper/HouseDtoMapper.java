package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.HouseDto;
import de.floschi.wagawindemo.family.data.response.HouseResponse;
import de.floschi.wagawindemo.family.db.entity.House;
import de.floschi.wagawindemo.family.db.entity.Person;
import org.springframework.stereotype.Component;

@Component
public class HouseDtoMapper {

    public House toHouse(HouseDto houseDto, Person personEntity) {
        return House.builder()
                .address(houseDto.getAddress())
                .zipCode(houseDto.getZipCode())
                .type(houseDto.getType())
                .person(personEntity)
                .build();
    }

    public HouseDto toHouseDto(House house) {
        return HouseDto.builder()
                .id(house.getHouseId())
                .address(house.getAddress())
                .zipCode(house.getZipCode())
                .type(house.getType())
                .build();
    }

    public HouseResponse toHouseResponse(House house) {
        return HouseResponse.builder()
                .id(house.getHouseId())
                .address(house.getAddress())
                .zipCode(house.getZipCode())
                .type(house.getType())
                .build();
    }

}
