package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Data
@Table(name="RegisterMedia")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class RegisterMedia {
    @Id
    @SequenceGenerator(name="RegisterMedia_seq",sequenceName="RegisterMedia_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RegisterMedia_seq")
    @Column(name="RegisterMedia_Id",unique = true, nullable = false)

    private @NonNull Long id_Media;

    @NotNull
    @Column(unique = true)
    private @NonNull String name_Media;

    @NotNull
    //@Column(unique = true)
    private @NonNull String name_Company_Media;

    @NotNull
    @Pattern(regexp = "[0-9]*")
    @Size(min=2, max=12)
    private @NonNull String tel;  ///////////////////

    @ManyToOne   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "idGender")      // join colume video_id จาก video กับ entity comment
    private GenderMedia genderMedia;

    @ManyToOne   //set fetch data เป็น LAZY LAZY = fetch when needed EAGER = fetch immediately
    @JoinColumn(name= "id_kind")      // join colume video_id จาก video กับ entity comment
    private KindMedia kindMedia;

    @ManyToOne
    @JoinColumn(name= "id_Sport")
    private KindSportMedia kindSportMedia;



    public Long getId_Media() {
        return id_Media;
    }

    public void setId_Media(Long id_Media) {
        this.id_Media = id_Media;
    }

    public String getName_Media() {
        return name_Media;
    }

    public void setName_Media(String name_Media) {
        this.name_Media = name_Media;
    }

    public String getName_Company_Media() {
        return name_Company_Media;
    }

    public void setName_Company_Media(String name_Company_Media) {
        this.name_Company_Media = name_Company_Media;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public GenderMedia getGenderMedia() {
        return genderMedia;
    }

    public void setGenderMedia(GenderMedia genderMedia) {
        this.genderMedia = genderMedia;
    }

    public KindMedia getKindMedia() {
        return kindMedia;
    }

    public void setKindMedia(KindMedia kindMedia) {
        this.kindMedia = kindMedia;
    }

    public KindSportMedia getKindSportMedia() {
        return kindSportMedia;
    }

    public void setKindSportMedia(KindSportMedia kindSportMedia) {
        this.kindSportMedia = kindSportMedia;
    }
}
