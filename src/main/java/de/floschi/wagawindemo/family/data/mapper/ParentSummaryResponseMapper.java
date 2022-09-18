package de.floschi.wagawindemo.family.data.mapper;

import de.floschi.wagawindemo.family.data.response.ParentSummaryResponse;
import de.floschi.wagawindemo.family.db.entity.ParentSummary;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ParentSummaryResponseMapper {

    default ParentSummaryResponse parentSummariesToResponse(List<ParentSummary> parentSummaries) {
        List<Integer> numberOfPersonsWithChild = parentSummaries.stream()
                .map(ParentSummary::getAmountOfPersons)
                .toList();
        return new ParentSummaryResponse(numberOfPersonsWithChild);
    }
}
