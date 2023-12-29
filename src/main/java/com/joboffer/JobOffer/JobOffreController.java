package com.joboffer.JobOffer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/offers")
public class JobOffreController {
    private final JobOffreService jobOffreService;

    @PostMapping
    public ResponseEntity<JobOffreRequest> createOffer(@RequestBody JobOffreRequest jobOffreRequest){
        JobOffreRequest savedOffer = jobOffreService.createJobOffer(jobOffreRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOffer);
    }
    @GetMapping
    public ResponseEntity<List<JobOffreResponse>> getAllOffers(){
        List<JobOffreResponse> list = jobOffreService.getAllOffers();
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<JobOffreResponse> findOfferById(@PathVariable Long id){
        JobOffreResponse jobOffreResponse = jobOffreService.getOfferById(id);
        if (jobOffreResponse != null){
            return ResponseEntity.ok(jobOffreResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("{id}")
    public String deleteOffer(@PathVariable Long id){
        jobOffreService.deleteOffer(id);
        return "Offer deleted with success";
    }
}
