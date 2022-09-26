package de.floschi.wagawindemo.parentsummaryjob.job;


import de.floschi.wagawindemo.parentsummaryjob.service.ParentSummaryCalcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


@Service
public class ParentSummaryJob {

    @Autowired
    private ParentSummaryCalcService parentSummaryCalcService;

    @Scheduled(fixedDelay = 6000) // 15 minutes
    //@Scheduled(cron = "0 0/2 * * * ?") // 15 minutes
    public void calculateParentSummary() {
        parentSummaryCalcService.calcParentSummary();
    }

}
