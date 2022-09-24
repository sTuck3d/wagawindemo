package de.floschi.wagawindemo.children.service;

import de.floschi.wagawindemo.children.data.dto.MealDto;
import de.floschi.wagawindemo.children.data.response.ChildInfoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@Sql(scripts = {"/testdata/child-info-test-data.sql"})
class ChildInfoServiceTest extends ChildServiceTestBase {


    @Autowired
    private ChildInfoService childInfoService;

    @Test
    public void loadChildInfo() {
        Long VALID_ID = 1L;
        var childInfoResponse = childInfoService.loadChildInfo(VALID_ID);
        assertNotNull(childInfoResponse);

        assertFavoriteMeal(childInfoResponse);
        var parent = childInfoResponse.getParent();
        assertNotNull(parent);
        assertEquals("Alfred", parent.getName());
    }

    @Test
    void loadChildInfo_unknownId_throwsIllegalArgumentException() {
        Long INVALID_ID = 1000L;
        assertThrows(IllegalArgumentException.class, () -> childInfoService.loadChildInfo(INVALID_ID));
    }

    private static void assertFavoriteMeal(ChildInfoResponse childInfoResponse) {
        Set<MealDto> favMeals = childInfoResponse.getFavoriteMeal();
        assertNotNull(favMeals);
        assertEquals(1, favMeals.size());
        MealDto favMeal = (MealDto) favMeals.toArray()[0];
        assertNotNull(favMeal);
        assertEquals("tacos", favMeal.getName());
    }
}