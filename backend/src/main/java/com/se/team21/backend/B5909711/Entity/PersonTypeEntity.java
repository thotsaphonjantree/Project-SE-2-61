package com.se.team21.backend.B5909711.Entity;
import lombok.*;
import javax.persistence.*;

@Entity
@Data
@Getter @Setter
//@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "PersonType")
public class PersonTypeEntity {
    @Id
    @SequenceGenerator(name="PersonTypeg_seq",sequenceName="PersonTypeg_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PersonTypeg_seq")
    @Column(name="PersonType_ID",unique = true, nullable = false)
    private @NonNull Long personTypeID;
    private @NonNull String personTypeName;

    public PersonTypeEntity(){}

    public String getPersonTypeName() {
        return personTypeName;
    }

    public void setPersonTypeName(String personTypeName) {
        this.personTypeName = personTypeName;
    }

    public Long getPersonTypeID() {
        return personTypeID;
    }

    public void setPersonTypeID(Long personTypeID) {
        this.personTypeID = personTypeID;
    }
}
