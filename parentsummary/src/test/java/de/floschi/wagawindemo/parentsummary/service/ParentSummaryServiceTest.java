package de.floschi.wagawindemo.parentsummary.service;

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

}