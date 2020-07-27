package gr.codehub.chgroupProject.service;

import gr.codehub.chgroupProject.excheption.JobOfferNotFoundException;
import gr.codehub.chgroupProject.model.JobOffer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JobOfferServiceImplTest {

    @Autowired
    JobOfferService jos;

    @Test
    void getJobOffers() {
        JobOffer jo1 = new JobOffer();
        jo1.setPosition("accentue");
        jo1.setAvailable(true);
        jo1.setRegion("athens");
        jo1.setId(1);

        jos.addJobOffer(jo1);
        jos.addJobOffer(jo1);

        assertEquals(2, jos.getJobOffers().size()); //TODO NA TO 3ANADW
    }

    @Test
    void addJobOffer() {
        List<JobOffer> jobOffers = new ArrayList<>();
        JobOffer jo1 = new JobOffer();
        jo1.setPosition("accentue");
        jo1.setAvailable(true);
        jo1.setRegion("athens");
        jo1.setId(1);

        JobOffer jo2 = new JobOffer();
        jo2.setPosition("european dynamic");
        jo2.setAvailable(false);
        jo2.setRegion("8essalonikh");
        jo2.setId(2);

        //jos.addJobOffer(jo1) kaloume thn sunarthsh apo to service pou epistrefei jobOffer
        jobOffers.add(jos.addJobOffer(jo1));  //epistrefoun mia job offer opote gia na dw oti trexei kala h sunarthsh 8a ta balw sthn arraylist pou eftia3a
        jobOffers.add(jos.addJobOffer(jo2));

        assertEquals(2, jobOffers.size());
    }

//    @Test
//    void updateJobOffer() {
//    }

    @Test
    void getJobOffer() throws JobOfferNotFoundException {
        JobOffer jo1 = new JobOffer();
        jo1.setPosition("accentue");
        jo1.setAvailable(true);
        jo1.setRegion("athens");
        jo1.setId(1);

        jos.addJobOffer(jo1);
        assertEquals("athens", jos.getJobOffer(1).getRegion());

    }
}