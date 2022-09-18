package de.floschi.wagawindemo.family.scheduling;


import de.floschi.wagawindemo.family.service.ParentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;


public class ParentSummaryJob {

    @Autowired
    private ParentSummaryService parentSummaryService;

    @Scheduled(fixedDelay = 900000) // 15 minutes
    public void calculateParentSummary() {
        parentSummaryService.calcParentSummary();
    }

}
