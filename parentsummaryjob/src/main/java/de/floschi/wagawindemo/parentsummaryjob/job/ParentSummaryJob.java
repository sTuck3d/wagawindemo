package de.floschi.wagawindemo.parentsummaryjob.job;


import de.floschi.wagawindemo.parentsummaryjob.db.entity.ParentSummary;
import de.floschi.wagawindemo.parentsummaryjob.service.ParentSummaryCalcService;
import de.floschi.wagawindemo.shared.logging.LogMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;


@Service
@Slf4j
public class ParentSummaryJob {

    @Autowired
    private ParentSummaryCalcService parentSummaryCalcService;

    @Scheduled(fixedDelay = 90000) // 15 minutes
    public void calculateParentSummary() {
        int maxNumberOfChildren = parentSummaryCalcService.loadMaxNumberOfChildren();

        ArrayList<Future<Integer>> numbersOfPersons = calcNumberOfPersonsAsync(maxNumberOfChildren);
        ArrayList<Integer> numbersOfPersonsValues = waitForNumberOfPersons(numbersOfPersons);

        for (int amountOfChildren = 0; amountOfChildren <= maxNumberOfChildren; amountOfChildren++) {
            parentSummaryCalcService.saveParentSummary(amountOfChildren, numbersOfPersonsValues.get(amountOfChildren));
        }
    }

    private ArrayList<Future<Integer>> calcNumberOfPersonsAsync(int maxNumberOfChildren) {
        ArrayList<Future<Integer>> numberOfPersons = new ArrayList<>();
        for (int amountOfChildren = 0; amountOfChildren <= maxNumberOfChildren; amountOfChildren++) {
            numberOfPersons.add(parentSummaryCalcService.getNumberOfPersons(amountOfChildren));
        }
        return numberOfPersons;
    }

    private ArrayList<Integer> waitForNumberOfPersons(ArrayList<Future<Integer>> numbersOfPersons) {
        var loadedNumbersOfPersons = new ArrayList<Integer>();
        numbersOfPersons.forEach(result -> {
            try {
                loadedNumbersOfPersons.add(result.get());
            } catch (InterruptedException | ExecutionException e) {
                log.debug("Error with executing NumberOfPersonsCalculation",e);
            }
        });
        return loadedNumbersOfPersons;
    }

}
