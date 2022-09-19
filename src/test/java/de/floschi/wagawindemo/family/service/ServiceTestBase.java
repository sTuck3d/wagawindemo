package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.scheduling.ParentSummaryJob;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@MockBean(ParentSummaryJob.class)
public class ServiceTestBase {
}
