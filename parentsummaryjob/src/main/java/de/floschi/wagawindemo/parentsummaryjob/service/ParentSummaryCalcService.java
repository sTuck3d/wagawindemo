package de.floschi.wagawindemo.parentsummaryjob.service;

import de.floschi.wagawindemo.parentsummaryjob.db.dao.ParentSummaryDao;
import de.floschi.wagawindemo.parentsummaryjob.db.dao.PersonDao;
import de.floschi.wagawindemo.parentsummaryjob.db.entity.ParentSummary;
import de.floschi.wagawindemo.shared.logging.LogMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.concurrent.Future;

@Service
@Transactional
public class ParentSummaryCalcService {

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ParentSummaryDao parentSummaryDao;

    @LogMethod
    public int loadMaxNumberOfChildren(){
        return personDao.getMaxNumberOfChildren();
    }

    @Async
    @LogMethod
    public Future<Integer> getNumberOfPersons(int numberOfChildren){
        return new AsyncResult<>(personDao.getNumberOfPersonsWithNumber(numberOfChildren));
    }

    public void saveParentSummary(int amountOfChildren, int amountOfPersons){
        parentSummaryDao.save(getParentSummary(amountOfChildren, amountOfPersons));
    }

    private ParentSummary getParentSummary(int amountOfChildren, int amountOfPersons) {
        Optional<ParentSummary> personWithNChildren =
                parentSummaryDao.findByAmountOfChildren(amountOfChildren);
        if (personWithNChildren.isPresent()) {
            // There is an entry in the db, that already contains this amount of children,
            // so just update the amount of persons.
            var existingParentSummary = personWithNChildren.get();
            existingParentSummary.setAmountOfPersons(amountOfPersons);
            return existingParentSummary;
        }
        // The number of children was not present in the db, so create a new entry
        return createNewParentSummary(amountOfChildren, amountOfPersons);
    }

    private ParentSummary createNewParentSummary(int amountOfChildren, int amountOfPersons) {
        var newParentSummary = new ParentSummary();
        newParentSummary.setAmountOfChildren(amountOfChildren);
        newParentSummary.setAmountOfPersons(amountOfPersons);
        return newParentSummary;
    }
}
