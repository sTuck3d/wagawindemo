package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.mapper.HouseDtoMapper;
import de.floschi.wagawindemo.family.data.response.HouseResponse;
import de.floschi.wagawindemo.family.db.dao.HouseDao;
import de.floschi.wagawindemo.family.logging.LogMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    @Autowired
    private HouseDao houseDao;

    @Autowired
    private HouseDtoMapper houseDtoMapper;

    @LogMethod
    @Cacheable(
            value = "houseCache",
            key = "#id")
    public HouseResponse loadHouseByPersonId(Long id) {
        return houseDao.loadAllByPersonId(id)
                .map(h -> houseDtoMapper.toHouseResponse(h))
                .orElse(null);
    }
}
