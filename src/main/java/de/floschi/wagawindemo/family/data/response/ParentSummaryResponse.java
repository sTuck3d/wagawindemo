package de.floschi.wagawindemo.family.data.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class ParentSummaryResponse implements Serializable {

    private List<Integer> parentSummary;
}
