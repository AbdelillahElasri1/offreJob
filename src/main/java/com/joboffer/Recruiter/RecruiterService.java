package com.joboffer.Recruiter;

import java.util.List;

public interface RecruiterService {
    RecruiterRequest createRecruiter(RecruiterRequest recruiterRequest);
    RecruiterRequest updateRecruiter(RecruiterRequest recruiterRequest);
    RecruiterResponse getRecruiterById(Long id);
    List<RecruiterResponse> getAllRecruiter();
    void deleteRecruiter(Long id);

}
