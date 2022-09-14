package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.PersonDto;
import de.floschi.wagawindemo.family.data.requests.PersonRequestDto;
import de.floschi.wagawindemo.family.data.response.ParentSummaryResponse;
import de.floschi.wagawindemo.family.service.ParentSummaryService;
import de.floschi.wagawindemo.family.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


    // CRUD Operations for manual testing and development
    @PutMapping
    public PersonDto putPerson(@RequestBody PersonRequestDto newPersonRequest) {
        return personService.savePerson(newPersonRequest);
    }

    @GetMapping("{personId}")
    public PersonDto getPerson(@PathVariable Long personId) {
        return personService.getPerson(personId);
    }

}
