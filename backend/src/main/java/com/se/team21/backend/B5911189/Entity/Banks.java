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

public class Banks {
    @Id
    @SequenceGenerator(name="bank_seq",sequenceName="bank_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="bank_seq")
    @Column(name="idBank",unique = true, nullable = false)
    private @NonNull Long idBank;
    private @NonNull String nameBank;

    public  Banks(String nameBank) {setNameBank(nameBank);}

    public void setIdBank(Long idbank) {this.idBank = idbank;}
    public Long getIdBank() {return idBank;}

    public void setNameBank(String namebank) {this.nameBank = namebank;}
    public String getNameBank() {return nameBank;}





}