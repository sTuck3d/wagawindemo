package de.floschi.wagawindemo.house.service;

import de.floschi.wagawindemo.house.db.enums.HouseType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@Sql(scripts = {"/testdata/house-service-test-data.sql"})
class HouseServiceTest {

    @Autowired
    private HouseService houseService;

    @Test
    void loadHouseByPersonId() {
        final Long VALID_PERSON_ID = 10L;
        var houseResponse = houseService.loadHouseByPersonId(VALID_PERSON_ID);

        assertNotNull(houseResponse);
        assertEquals(HouseType.FLAT, houseResponse.getType());
        assertEquals("Str", houseResponse.getAddress());
    }

    @Test
    void loadHouseByPersonId_unknownId_returnsNull() {
        final Long INVALID_ID = 1000L;

        assertNull(houseService.loadHouseByPersonId(INVALID_ID));
    }
}