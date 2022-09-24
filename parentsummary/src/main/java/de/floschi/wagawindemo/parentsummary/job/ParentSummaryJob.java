package de.floschi.wagawindemo.parentsummary.job;


import de.floschi.wagawindemo.parentsummary.service.ParentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class ParentSummaryJob {

    @Autowired
    private ParentSummaryService parentSummaryService;

    @Scheduled(fixedDelay = 900000) // 15 minutes
    public void calculateParentSummary() {
        parentSummaryService.calcParentSummary();
    }

}
