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

public class Transfer {
    @Id
    @SequenceGenerator(name="Transfer_seq",sequenceName="Transfer_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Transfer_seq")
    @Column(name="idTransfer",unique = true, nullable = false)
    private @NonNull Long idTransfer;
    private @NonNull String nameTransfer;


    public  Transfer(String nameTransfer) {setNameTransfer(nameTransfer);}

    public void setIdStatus(Long idTransfer) {this.idTransfer = idTransfer;}
    public Long getIdTransfer() {return idTransfer;}

    public void setNameTransfer(String nameTransfer) {this.nameTransfer = nameTransfer;}
    public String getNameTransfer() {return nameTransfer;}





}