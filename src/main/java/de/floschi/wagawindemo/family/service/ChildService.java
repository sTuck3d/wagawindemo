package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.response.ChildColorResponse;
import de.floschi.wagawindemo.family.data.response.ChildInfoResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class ChildService {

    public Mono<ChildInfoResponse> loadChildInfo(Long id) {
        return null; // TODO: Implement
    }

    public Mono<ChildColorResponse> loadChildFavColor(Long id) {
        return null; // TODO: implement
    }

}
