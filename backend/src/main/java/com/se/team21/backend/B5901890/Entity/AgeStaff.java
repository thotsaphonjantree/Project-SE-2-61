package com.se.team21.backend.B5901890.Entity;

import lombok.*;

import javax.persistence.*;

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

    private @NonNull Long idAge;
    private @NonNull Integer age;

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
