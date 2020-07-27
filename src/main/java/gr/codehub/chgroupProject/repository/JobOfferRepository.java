package gr.codehub.chgroupProject.repository;


import gr.codehub.chgroupProject.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface JobOfferRepository extends JpaRepository<JobOffer, Integer> {
}
