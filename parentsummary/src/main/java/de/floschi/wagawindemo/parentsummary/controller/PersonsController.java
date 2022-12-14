package de.floschi.wagawindemo.parentsummary.controller;

import de.floschi.wagawindemo.parentsummary.data.response.ParentSummaryResponse;
import de.floschi.wagawindemo.parentsummary.service.ParentSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("persons")
public class PersonsController {

    @Autowired
    private ParentSummaryService parentSummaryService;

    @GetMapping("/children")
    public Callable<ParentSummaryResponse> getChildInfo() {
        return () -> parentSummaryService.loadParentSummary();
    }
}
