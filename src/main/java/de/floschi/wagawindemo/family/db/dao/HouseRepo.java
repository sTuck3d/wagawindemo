package de.floschi.wagawindemo.family.db.dao;

import de.floschi.wagawindemo.family.db.entity.House;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepo extends R2dbcRepository<House, Long> {
}
