package de.floschi.wagawindemo.children.service;

import de.floschi.wagawindemo.children.data.response.ChildBicycleColorResponse;
import de.floschi.wagawindemo.children.data.response.ChildHairColorResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Sql(scripts = {"/testdata/child-color-test-data.sql"})
class ChildColorServiceTest extends ChildServiceTestBase {

    @Autowired
    private ChildColorService childColorService;

    // ID-Values from child-color-test-data.sql:
    private final static Long SON_ID = 1L;
    private final static Long DAUGHTER_ID = 2L;
    private final static Long INVALID_ID = 100L;

    @Test
    void loadChildFavColor_son() {
        var childColorResponse = childColorService.loadChildFavColor(SON_ID);

        assertEquals(ChildBicycleColorResponse.class, childColorResponse.getClass());
        var bicycleColorResponse = (ChildBicycleColorResponse) childColorResponse;
        assertEquals("blue", bicycleColorResponse.getBicycleColor());
    }

    @Test
    void loadChildFavColor_daughter() {
        var childColorResponse = childColorService.loadChildFavColor(DAUGHTER_ID);

        assertEquals(ChildHairColorResponse.class, childColorResponse.getClass());
        var childHairColorResponse = (ChildHairColorResponse) childColorResponse;
        assertEquals("red", childHairColorResponse.getHairColor());
    }

    @Test
    void loadChildFavColor_unknownId() {
        var childColorResponse = childColorService.loadChildFavColor(INVALID_ID);
        assertNull(childColorResponse);
    }
}