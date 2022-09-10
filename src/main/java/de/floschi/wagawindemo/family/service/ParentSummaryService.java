package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.response.ParentSummaryResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ParentSummaryService {

    public Mono<ParentSummaryResponse> loadParentSummary() {
        return null; // TODO: Implement
    }
}
