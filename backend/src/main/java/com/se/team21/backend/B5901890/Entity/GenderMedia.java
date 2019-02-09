package com.se.team21.backend.B5901890.Entity;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.*;

@Entity
@Data
@Table(name="GenderMedia")
@ToString
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class GenderMedia {
    @Id
    @SequenceGenerator(name="GenderMedia_seq",sequenceName="GenderMedia_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GenderMedia_seq")
    @Column(name="GenderMedia_Id",unique = true, nullable = false)
    private @NonNull Long idGenderM;


    private @NonNull String nameGenderM;

    public Long getIdGenderM() {
        return idGenderM;
    }

    public void setIdGenderM(Long idGenderM) {
        this.idGenderM = idGenderM;
    }

    public String getNameGenderM() {
        return nameGenderM;
    }

    public void setNameGenderM(String nameGenderM) {
        this.nameGenderM = nameGenderM;
    }
}
