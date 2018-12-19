package com.team21.backend.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.*;


@Entity
@Data
@Table(name="RegisterStaff")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class RegisterStaff {
    @Id
    @SequenceGenerator(name="RegisterStaff_seq",sequenceName="RegisterStaff_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RegisterStaff_seq")
    @Column(name="RegisterStaff_Id",unique = true, nullable = false)

    private @NonNull Long idRegister;
    private @NonNull String nameRegisterStaff;
    private @NonNull Integer tell;



  /*  @OneToMany(
            mappedBy="activity", //bind many to one กับ comment
            cascade = CascadeType.ALL,
            orphanRemoval = true) //delete Cascade
    private List<Gender> Gender = new ArrayList<>();
*/


    @ManyToOne   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idGender")      // join colume video_id จาก video กับ entity comment
    private GenderStaff genderStaff;

    @ManyToOne   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idWork")      // join colume video_id จาก video กับ entity comment
    private WorkStaff workStaff;



    @ManyToOne
    @JoinColumn(name= "idAge")
    private AgeStaff ageStaff;





    public Long getIdRegirter() {
        return idRegister;
    }

    public void setIdRegirter(Long idRegirter) {
        this.idRegister = idRegister;
    }

    public String getNameStaff() {
        return nameRegisterStaff;
    }

    public void setNameStaff(String nameStaff)
    {
        this.nameRegisterStaff = nameStaff;
    }



    public Integer getTell() {

        return tell;
    }

    public void setTell(Integer tell) {
        this.tell = tell;
    }




    public GenderStaff getGenderStaff() {
        return genderStaff;
    }

    public void setGenderStaff(GenderStaff genderStaff) {
        this.genderStaff = genderStaff;
    }

    public WorkStaff getWorkStaff() {
        return workStaff;
    }

    public void setWorkStaff(WorkStaff workStaff) {
        this.workStaff = workStaff;
    }

    public AgeStaff getAgeStaff() {
        return ageStaff;
    }

    public void setAgeStaff(AgeStaff ageStaff) {
        this.ageStaff = ageStaff;
    }
}
