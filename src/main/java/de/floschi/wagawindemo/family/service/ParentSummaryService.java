package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.mapper.ParentSummaryResponseMapper;
import de.floschi.wagawindemo.family.data.response.ParentSummaryResponse;
import de.floschi.wagawindemo.family.db.dao.ParentSummaryDao;
import de.floschi.wagawindemo.family.db.dao.PersonDao;
import de.floschi.wagawindemo.family.db.entity.ParentSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ParentSummaryService {

    @Autowired
    private ParentSummaryDao parentSummaryDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ParentSummaryResponseMapper parentSummaryMapper;

    public ParentSummaryResponse loadParentSummary() {
        var allParentSummaries = parentSummaryDao.findAll(Sort.by(Sort.Direction.ASC, "amountOfChildren"));
        return parentSummaryMapper.parentSummariesToResponse(allParentSummaries);
    }

    /**
     * Calculates {@link de.floschi.wagawindemo.family.db.entity.ParentSummary}, so the amount of persons that have n
     * number of children.
     */
    @Transactional
    public void calcParentSummary() {
        int maxNumberOfChildren = personDao.getMaxNumberOfChildren();
        for (int amountOfChildren = 0; amountOfChildren < maxNumberOfChildren; amountOfChildren++) {
            loadAndSaveParentSummary(amountOfChildren);
        }
    }

    private void loadAndSaveParentSummary(int amountOfChildren) {
        int amountOfPersons = personDao.getNumberOfPersonsWithNumber(amountOfChildren);
        var parentSummary = getParentSummary(amountOfChildren, amountOfPersons);
        parentSummaryDao.save(parentSummary);
    }

    private ParentSummary getParentSummary(int amountOfChildren, int amountOfPersons) {
        Optional<ParentSummary> personWithNChildren =
                parentSummaryDao.findByAmountOfChildren(amountOfChildren);
        if (personWithNChildren.isPresent()) {
            // There is an entry in the db, that already saves this amount of children,
            // so just update the amount of persons.
            var existingParentSummary = personWithNChildren.get();
            existingParentSummary.setAmountOfPersons(amountOfPersons);
            return existingParentSummary;
        }
        // The number of children was not present in the db, so create a new entry
        return createNewParentSummary(amountOfChildren, amountOfPersons);
    }

    private static ParentSummary createNewParentSummary(int amountOfChildren, int amountOfPersons) {
        var newParentSummary = new ParentSummary();
        newParentSummary.setAmountOfChildren(amountOfChildren);
        newParentSummary.setAmountOfPersons(amountOfPersons);
        return newParentSummary;
    }
}
