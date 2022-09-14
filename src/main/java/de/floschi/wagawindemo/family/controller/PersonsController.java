package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.response.ParentSummaryResponse;
import de.floschi.wagawindemo.family.service.ParentSummaryService;
import de.floschi.wagawindemo.family.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("persons")
public class PersonsController {

    @Autowired
    private ParentSummaryService parentSummaryService;

    @Autowired
    private PersonService personService;

    @GetMapping("/children")
    public ParentSummaryResponse getChildInfo() {
        return parentSummaryService.loadParentSummary();
    }
}
