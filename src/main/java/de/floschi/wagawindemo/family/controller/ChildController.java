package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.response.ChildColorResponse;
import de.floschi.wagawindemo.family.data.response.ChildInfoResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("child")
public class ChildController {

    @GetMapping("/info/{childId}")
    public Mono<ChildInfoResponse> getChildInfo(@PathVariable String childId) {
        return null; // TODO: Implement
    }

    @GetMapping("/color/{childId}")
    public Mono<ChildColorResponse> getChildFavColor(@PathVariable String childId) {
        return null; // TODO: Implement
    }

}
