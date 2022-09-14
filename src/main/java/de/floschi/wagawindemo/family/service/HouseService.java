package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.HouseDto;
import de.floschi.wagawindemo.family.data.mapper.HouseDtoMapper;
import de.floschi.wagawindemo.family.data.response.HouseResponse;
import de.floschi.wagawindemo.family.db.dao.HouseRepo;
import de.floschi.wagawindemo.family.db.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    private HouseRepo houseRepo;

    @Autowired
    private HouseDtoMapper houseDtoMapper;

    public HouseResponse loadHouseByPersonId(Long id) {
        return houseRepo.loadAllByPersonId(id)
                .map(h -> houseDtoMapper.toHouseResponse(h))
                .orElse(null);
    }

    public HouseDto saveHouse(HouseDto houseDto, Person personEntity) {
        var newHouse = houseDtoMapper.toHouse(houseDto, personEntity);
        var savedHouse = houseRepo.save(newHouse);
        return houseDtoMapper.toHouseDto(savedHouse);
    }

}
