package gr.codehub.chgroupProject.repository;

import gr.codehub.chgroupProject.model.ApplicantSkill;
import gr.codehub.chgroupProject.model.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicantSkillRepository extends JpaRepository<ApplicantSkill, Integer>{
}