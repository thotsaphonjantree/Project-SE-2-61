package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="GenderStaff")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class GenderStaff {
    @Id
    @SequenceGenerator(name="Gender_seq",sequenceName="Gender_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Gender_seq")
    @Column(name="Gender_Id",unique = true, nullable = false)
    private @NonNull Long idGender;
    private @NonNull String nameGender;


   /* @ManyToOne(fetch = FetchType.LAZY)   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "IdActivity")      // join colume video_id จาก video กับ entity comment
    private Activity activity;

    protected Gender(){}
    */

   /* @OneToMany(
            mappedBy="gender", //bind many to one กับ comment
            cascade = CascadeType.ALL,
            orphanRemoval = true) //delete Cascade
    private List<Activity> Activity = new ArrayList<>();
*/

    public Long getIdGender() {
        return idGender;
    }

    public void setIdGender(Long idGender) {
        this.idGender = idGender;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }
}
