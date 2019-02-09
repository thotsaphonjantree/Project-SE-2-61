package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


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

    @NotNull
    @Column(unique = true)
    private String nameRegisterStaff;

    @Pattern(regexp = "[0-9]*")
    @Size(min=3, max=12)
    @NotNull
    private  String tell;



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



    public String getTell() {

        return tell;
    }

    public void setTell(String tell) {
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
