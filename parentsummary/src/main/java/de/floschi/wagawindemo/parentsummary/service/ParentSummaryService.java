package de.floschi.wagawindemo.parentsummary.service;

import de.floschi.wagawindemo.shared.logging.LogMethod;
import de.floschi.wagawindemo.parentsummary.data.mapper.ParentSummaryResponseMapper;
import de.floschi.wagawindemo.parentsummary.data.response.ParentSummaryResponse;
import de.floschi.wagawindemo.parentsummary.db.dao.ParentSummaryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ParentSummaryService {

    @Autowired
    private ParentSummaryDao parentSummaryDao;

    @Autowired
    private ParentSummaryResponseMapper parentSummaryMapper;

    @Cacheable(value = "parentSummaryCache")
    @LogMethod
    public ParentSummaryResponse loadParentSummary() {
        var allParentSummaries = parentSummaryDao.findAll(Sort.by(Sort.Direction.ASC, "amountOfChildren"));
        return parentSummaryMapper.parentSummariesToResponse(allParentSummaries);
    }

}
