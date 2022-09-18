package de.floschi.wagawindemo.family.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ParentSummaryResponse {

    private List<Integer> parentSummary;
}
