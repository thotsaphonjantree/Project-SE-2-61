package com.se.team21.backend.B5911189.Entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString

public class FromTo {
    @Id
    @SequenceGenerator(name="FromTo_seq",sequenceName="FromTo_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FromTo_seq")
    @Column(name="idFromTo",unique = true, nullable = false)
    private @NonNull Long idFromTo;
    private @NonNull String nameFromTo;

    public FromTo(String namefromto) {setNameFromTo(namefromto);}

    public void setIdFromTo(Long idformto) {this.idFromTo = idformto;}
    public Long getIdFromTo() {return idFromTo;}


    public void setNameFromTo(String namefromto) {this.nameFromTo = namefromto;}
    public String getNameFromTo() {return nameFromTo;}





}