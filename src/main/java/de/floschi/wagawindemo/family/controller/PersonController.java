package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.response.ParentSummaryResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("persons")
public class PersonController {

    @GetMapping("/children")
    public Mono<ParentSummaryResponse> getChildInfo() {
        return null; // TODO: Implement
    }

}
