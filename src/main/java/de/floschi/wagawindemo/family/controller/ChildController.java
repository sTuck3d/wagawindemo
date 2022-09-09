package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.response.ChildBicycleColorResponse;
import de.floschi.wagawindemo.family.data.response.ChildColorResponse;
import de.floschi.wagawindemo.family.data.response.ChildInfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("child")
public class ChildController {

    @GetMapping("/info/{childId}")
    public ChildInfoResponse getChildInfo(@PathVariable String childId) {
        return new ChildInfoResponse(); // TODO: Implement
    }

    @GetMapping("/color/{childId}")
    public ChildColorResponse getChildFavColor(@PathVariable String childId) {
        return new ChildBicycleColorResponse(); // TODO: Implement
    }

}
