package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="WorkStaff")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class WorkStaff {
    @Id
    @SequenceGenerator(name="WorkStaff_seq",sequenceName="WorkStaff_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="WorkStaff_seq")
    @Column(name="WorkStaff_Id",unique = true, nullable = false)

    private @NotNull Long idWork;

    private @NotNull (message="AgeStaff must not be null to be valid")
    @NonNull String work;


 /*   @OneToMany(
            mappedBy="kindActivity", //bind many to one กับ comment
            cascade = CascadeType.ALL,
            orphanRemoval = true) //delete Cascade
    private List<Activity> Activity = new ArrayList<>();
    */


    public Long getIdWork() {
        return idWork;
    }

    public void setIdWork(Long idWork) {
        this.idWork = idWork;
    }

    public String getWork() {
        return work;
    }

    public void setWork(String work) {
        this.work = work;
    }
}
