package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@Table(name="GenderMedia")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class GenderMedia {
    @Id
    @SequenceGenerator(name="Gender_seq",sequenceName="Gender_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Gender_seq")
    @Column(name="Gender_Id",unique = true, nullable = false)
    private @NonNull Long idGender;


    private @NonNull String nameGender;


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
