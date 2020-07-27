package gr.codehub.chgroupProject.controller;

import gr.codehub.chgroupProject.excheption.JobOfferNotFoundException;
import gr.codehub.chgroupProject.model.JobOffer;
import gr.codehub.chgroupProject.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class JobOfferController {

    @Autowired
    private JobOfferService jobOfferService;

    @GetMapping("jobOffer")
    public List<JobOffer> getListOfJobOffers() {
        return jobOfferService.getJobOffers();
    }

    @PostMapping("jobOffer")
    public JobOffer addJobOffer(@RequestBody JobOffer JobOffer)
    //todo   throws CustomerCreationException
    {
        return jobOfferService.addJobOffer(JobOffer);
    }

    @GetMapping("jobOffer/{jobOfferId}")
    public JobOffer getJobOfferById(@PathVariable int jobOfferId) throws JobOfferNotFoundException//todo throws CustomerNotFoundException {
    {
        return jobOfferService.getJobOffer(jobOfferId);//epistrefei ena json
    }


}