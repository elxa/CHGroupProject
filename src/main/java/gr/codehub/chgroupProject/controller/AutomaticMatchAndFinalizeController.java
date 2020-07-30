package gr.codehub.chgroupProject.controller;

import gr.codehub.chgroupProject.exception.ApplicantNotFoundException;
import gr.codehub.chgroupProject.exception.CreateAndMatchNotFound;
import gr.codehub.chgroupProject.exception.JobOfferNotFoundException;
import gr.codehub.chgroupProject.exception.SkillNotFoundException;
import gr.codehub.chgroupProject.model.ApplicantSkill;
import gr.codehub.chgroupProject.model.CreateAndMatch;
import gr.codehub.chgroupProject.model.JobOfferSkill;
import gr.codehub.chgroupProject.service.ApplicantSkillService;
import gr.codehub.chgroupProject.service.matcher.CreateManualMatchService;
import gr.codehub.chgroupProject.service.JobOfferSkillService;
import gr.codehub.chgroupProject.service.matcher.AutomaticMatchServiceImpl;
import gr.codehub.chgroupProject.service.matcher.FinalizeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class AutomaticMatchAndFinalizeController {

    @Autowired
    private CreateManualMatchService createManualMatchService;

    @Autowired
    private AutomaticMatchServiceImpl automaticMatchServiceImpl;

    @Autowired
    private FinalizeServiceImpl finalizeServiceImpl;


    @GetMapping("matching")
    public List<CreateAndMatch> doMatch(@RequestParam(required = false) boolean partial)
            throws ApplicantNotFoundException, JobOfferNotFoundException,
            SkillNotFoundException {

        return automaticMatchServiceImpl.DoAutomaticMatch(partial);
    }

    @GetMapping("finalize/{createAndMatchId}")
    public CreateAndMatch finalizeMatch(@PathVariable int createAndMatchId)
            throws CreateAndMatchNotFound, ApplicantNotFoundException, JobOfferNotFoundException {

        return finalizeServiceImpl.doFinalize(createManualMatchService.findCreateAndMatch(createAndMatchId));


    }

}