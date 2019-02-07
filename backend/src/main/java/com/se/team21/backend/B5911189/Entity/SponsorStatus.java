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

public class SponsorStatus {
    @Id
    @SequenceGenerator(name="SponsorStatus_seq",sequenceName="SponsorStatus_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SponsorStatus_seq")
    @Column(name="idStatus",unique = true, nullable = false)
    private @NonNull Long idStatus;
    private @NonNull String nameStatus;
    

    public  SponsorStatus(String nameStatus) {setNameStatus(nameStatus);}

    public void setIdStatus(Long idStatus) {this.idStatus = idStatus;}
    public Long getIdStatus() {return idStatus;}

    public void setNameStatus(String nameStatus) {this.nameStatus = nameStatus;}
    public String getNameStatus() {return nameStatus;}





}