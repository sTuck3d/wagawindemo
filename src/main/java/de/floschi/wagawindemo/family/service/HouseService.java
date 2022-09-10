package de.floschi.wagawindemo.family.service;

import de.floschi.wagawindemo.family.data.response.HouseResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class HouseService {

    public Mono<HouseResponse> loadHouseByPersonId(Long id) {
        return null; // TODO: Implement
    }

}
