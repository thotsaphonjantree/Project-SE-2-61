package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table(name="AgeStaff")
@ToString
@Getter @Setter
@EqualsAndHashCode
public class AgeStaff {
    @Id
    @SequenceGenerator(name="age_seq",sequenceName="age_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="age_seq")
    @Column(name="age_Id",unique = true, nullable = false)

    private @NotNull Long idAge;

    private @NotNull (message="AgeStaff must not be null to be valid")
    Integer age;

    public Long getIdAge() {
        return idAge;
    }

    public void setIdAge(Long idAge) {
        this.idAge = idAge;
    }

    public Integer getAge() {
        return age;
    }
    public AgeStaff(){}
    public void setAge(Integer age) {
        this.age = age;
    }
}
