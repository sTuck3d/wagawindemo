package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.response.HouseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("house")
public class HouseController {

    @GetMapping("/{personId}")
    public Mono<HouseResponse> getPersonsHouse(@PathVariable String personId) {
        return null; // TODO: Implement
    }


}
