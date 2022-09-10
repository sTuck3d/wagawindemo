package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.response.HouseResponse;
import de.floschi.wagawindemo.family.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/{personId}")
    public Mono<HouseResponse> getPersonsHouse(@PathVariable Long personId) {
        return houseService.loadHouseByPersonId(personId);
    }


}
