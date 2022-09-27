package de.floschi.wagawindemo.house.controller;

import de.floschi.wagawindemo.house.data.response.HouseResponse;
import de.floschi.wagawindemo.house.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @GetMapping("/{personId}")
    public Callable<HouseResponse> getPersonsHouse(@PathVariable Long personId) {
        return () -> houseService.loadHouseByPersonId(personId);
    }


}
