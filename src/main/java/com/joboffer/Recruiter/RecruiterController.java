package com.joboffer.Recruiter;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/recruiter")
public class RecruiterController {
    private final RecruiterService recruiterService;

    @PostMapping
    public ResponseEntity<RecruiterRequest> createRecruiter(RecruiterRequest recruiterRequest){
        RecruiterRequest savedRecruiter = recruiterService.createRecruiter(recruiterRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecruiter);
    }
    @GetMapping
    public ResponseEntity<List<RecruiterResponse>> findAllRecruiter(){
        List<RecruiterResponse> list = recruiterService.getAllRecruiter();
        return ResponseEntity.ok(list);
    }
    @GetMapping("{id}")
    public ResponseEntity<RecruiterResponse> findRecruiterById(@PathVariable Long id){
        RecruiterResponse response = recruiterService.getRecruiterById(id);
        if (response != null){
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public String deleteRecruiter(@PathVariable Long id){
        recruiterService.deleteRecruiter(id);
        return "Recruiter deleted with success";
    }
}
