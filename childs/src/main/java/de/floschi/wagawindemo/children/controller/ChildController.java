package de.floschi.wagawindemo.children.controller;

import de.floschi.wagawindemo.children.data.response.ChildColorResponse;
import de.floschi.wagawindemo.children.data.response.ChildInfoResponse;
import de.floschi.wagawindemo.children.service.ChildColorService;
import de.floschi.wagawindemo.children.service.ChildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("child")
public class ChildController {

    @Autowired
    private ChildInfoService childInfoService;

    @Autowired
    private ChildColorService childColorService;

    @GetMapping("/info/{childId}")
    public Callable<ChildInfoResponse> getChildInfo(@PathVariable Long childId) throws InterruptedException {
        return () -> childInfoService.loadChildInfo(childId);
    }

    @GetMapping("/color/{childId}")
    public Callable<ChildColorResponse> getChildFavColor(@PathVariable Long childId) {
        return () -> childColorService.loadChildFavColor(childId);
    }

}
