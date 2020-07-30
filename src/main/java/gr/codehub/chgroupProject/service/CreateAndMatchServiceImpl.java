package gr.codehub.chgroupProject.service;

import gr.codehub.chgroupProject.exception.ApplicantNotFoundException;
import gr.codehub.chgroupProject.exception.CreateAndMatchNotFound;
import gr.codehub.chgroupProject.exception.JobOfferNotFoundException;
import gr.codehub.chgroupProject.model.Applicant;
import gr.codehub.chgroupProject.model.CreateAndMatch;
import gr.codehub.chgroupProject.model.JobOffer;
import gr.codehub.chgroupProject.repository.ApplicantRepository;
import gr.codehub.chgroupProject.repository.CreateAndMatchRepository;
import gr.codehub.chgroupProject.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateAndMatchServiceImpl implements CreateAndMatchService {

    @Autowired
    private CreateAndMatchRepository camRepo;
    @Autowired
    private ApplicantRepository applicantRepo;
    @Autowired
    private JobOfferRepository jobOfferRepo;

    @Override
    public List<CreateAndMatch> getCreateAndMatch() {
        return camRepo.findAll();
    }

    @Override
    public CreateAndMatch addCreateAndMatch(int applicantId, int jobOfferId) throws ApplicantNotFoundException, JobOfferNotFoundException {
        Applicant applicantInDb = applicantRepo.findById(applicantId)
                .orElseThrow(
                        () -> new ApplicantNotFoundException("Applicant Not Found")
                );

        JobOffer jobOfferInDb = jobOfferRepo.findById(jobOfferId)
                .orElseThrow(
                        () -> new JobOfferNotFoundException("Job Offer Not Found")
                );


        CreateAndMatch createAndMatch = new CreateAndMatch();
        createAndMatch.setApplicant(applicantInDb);
        createAndMatch.setJobOffer(jobOfferInDb);

        return camRepo.save(createAndMatch);
    }

    @Override
    public CreateAndMatch updateCreateAndMatch(CreateAndMatch createAndMatch, int createAndMatchId) throws CreateAndMatchNotFound {
        CreateAndMatch createAndMatchInDb = camRepo.findById(createAndMatchId)
                .orElseThrow(
                        () -> new CreateAndMatchNotFound("Match Not Found"));

        createAndMatchInDb.setAvailable(createAndMatch.isAvailable());
        return camRepo.save(createAndMatchInDb);

    }
}