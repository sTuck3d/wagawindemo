package de.floschi.wagawindemo.family.controller;

import de.floschi.wagawindemo.family.data.response.ChildColorResponse;
import de.floschi.wagawindemo.family.data.response.ChildInfoResponse;
import de.floschi.wagawindemo.family.service.ChildColorService;
import de.floschi.wagawindemo.family.service.ChildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("child")
public class ChildController {

    @Autowired
    private ChildInfoService childInfoService;

    @Autowired
    private ChildColorService childColorService;

    @GetMapping("/info/{childId}")
    public ChildInfoResponse getChildInfo(@PathVariable Long childId) {
        return childInfoService.loadChildInfo(childId);
    }

    @GetMapping("/color/{childId}")
    public ChildColorResponse getChildFavColor(@PathVariable Long childId) {
        return childColorService.loadChildFavColor(childId);
    }

}
