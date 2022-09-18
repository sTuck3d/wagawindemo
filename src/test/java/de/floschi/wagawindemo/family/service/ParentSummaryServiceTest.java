package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.db.dao.ParentSummaryDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class ParentSummaryServiceTest {

    @Autowired
    private ParentSummaryService parentSummaryService;

    @Autowired
    private ParentSummaryDao parentSummaryDao;

    @Test
    @Sql(scripts = {"/testdata/parent-summary-test-data.sql"})
    void loadParentSummary() {
        var parentSummaryResponse = parentSummaryService.loadParentSummary();

        assertNotNull(parentSummaryResponse);
        var parentSummary = parentSummaryResponse.getParentSummary();
        // The parentSummary should look like this: [1,2,3]
        assertNotNull(parentSummary);
        assertEquals(3, parentSummary.size());
        assertEquals(1, parentSummary.get(0));
        assertEquals(2, parentSummary.get(1));
        assertEquals(3, parentSummary.get(2));
    }

    @Test
    @Sql(scripts = {"/testdata/calc-parent-summary-test-data.sql"})
    void calcParentSummary() {
        parentSummaryService.calcParentSummary();

        // There should be three entries in the parent summary table:
        // (amountOfPersons, amountOfChildren) [0,0], [0,1] and [1,2]
        var parentSummaries = parentSummaryDao.findAll();
        assertNotNull(parentSummaries);
        assertEquals(3, parentSummaries.size());
        var firstEntry = parentSummaries.get(0);
        assertEquals(0, firstEntry.getAmountOfPersons());
        assertEquals(0, firstEntry.getAmountOfChildren());
        var secondEntry = parentSummaries.get(1);
        assertEquals(0, secondEntry.getAmountOfPersons());
        assertEquals(1, secondEntry.getAmountOfChildren());
        var thirdEntry = parentSummaries.get(2);
        assertEquals(1, thirdEntry.getAmountOfPersons());
        assertEquals(2, thirdEntry.getAmountOfChildren());
    }

    @Test
    @Sql(scripts = {"/testdata/calc-parent-summary-overrides-test-data.sql"})
    void calcParentSummary_overrides() {
        parentSummaryService.calcParentSummary();

        // There should be four entries in the parent summary table now:
        // (amountOfPersons, amountOfChildren) [0,0], [0,1] and [1,2]
        var parentSummaries = parentSummaryDao.findAll();
        assertNotNull(parentSummaries);
        assertEquals(3, parentSummaries.size());
        var firstEntry = parentSummaries.get(0);
        assertEquals(0, firstEntry.getAmountOfPersons());
        assertEquals(0, firstEntry.getAmountOfChildren());
        var secondEntry = parentSummaries.get(1);
        assertEquals(0, secondEntry.getAmountOfPersons());
        assertEquals(1, secondEntry.getAmountOfChildren());
        var thirdEntry = parentSummaries.get(2);
        assertEquals(1, thirdEntry.getAmountOfPersons());
        assertEquals(2, thirdEntry.getAmountOfChildren());

    }
}