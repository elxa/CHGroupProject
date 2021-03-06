package gr.codehub.chgroupProject.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ApplicantSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //    @JoinColumn(name = "skill", referencedColumnName = "skill")
    @ManyToOne
    private Skill skill;

    /**
     * Specify a relationship from the embeddable class to an entity class.
     * @ManyToOne
     */
//    @JoinColumn(name = "applicant", referencedColumnName = "applicant")
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private Applicant applicant;
}
