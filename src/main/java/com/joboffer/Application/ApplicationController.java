package com.joboffer.Application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/application")
public class ApplicationController {
    private final ApplicationService applicationService;
    @PostMapping
    public ResponseEntity<ApplicationRequest> createApplication(@Validated @RequestBody ApplicationRequest applicationRequest){
        ApplicationRequest savedApplication = applicationService.createApplication(applicationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedApplication);
    }

    @GetMapping
    public ResponseEntity<List<ApplicationResponse>> getAllApplications(){
        List<ApplicationResponse> applicationResponseList = applicationService.getAllApplications();
        return ResponseEntity.ok(applicationResponseList);
    }
    @GetMapping("{id}")
    public ResponseEntity<ApplicationResponse> getApplicationById(@PathVariable Long id){
        ApplicationResponse applicationResponse = applicationService.getApplicationById(id);
        if (applicationResponse != null){
            return ResponseEntity.ok(applicationResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public String deleteApplication(@PathVariable Long id){
        applicationService.deleteApplication(id);
        return "Application deleted with success";
    }
}
