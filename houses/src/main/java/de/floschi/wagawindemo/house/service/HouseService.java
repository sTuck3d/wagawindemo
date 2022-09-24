package de.floschi.wagawindemo.house.service;

import de.floschi.wagawinddemo.shared.logging.LogMethod;
import de.floschi.wagawindemo.house.data.mapper.HouseDtoMapper;
import de.floschi.wagawindemo.house.data.response.HouseResponse;
import de.floschi.wagawindemo.house.db.dao.HouseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    private HouseDao houseDao;

    @Autowired
    private HouseDtoMapper houseDtoMapper;

    @Cacheable(
            value = "houseCache",
            key = "#id")
    @LogMethod
    public HouseResponse loadHouseByPersonId(Long id) {
        return houseDao.loadAllByPersonId(id)
                .map(h -> houseDtoMapper.toHouseResponse(h))
                .orElse(null);
    }
}
