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

public  class  SponsorRegis{
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name="SponsorRegis_seq",sequenceName="SponsorRegis_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SponsorRegis_seq")
    @Column(name="idSponsorRegis",unique = true, nullable = false)
    private @NonNull Long idSponsorRegis;
    private @NonNull String nameSponsorRegis;
    private @NonNull String Amount;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = Banks.class)
    @JoinColumn(name= "idTransfer",insertable = true)
    private Transfer transfer;

    @ManyToOne(fetch = FetchType.EAGER,targetEntity = IncomeExpenses.class)
    @JoinColumn(name= "idStatus",insertable = true)
    private SponsorStatus sponsorstatus;





    public void setIdSponsorRegis(Long idSponsorRegis) { this.idSponsorRegis = idSponsorRegis; }
    public Long getIdSponsorRegis() {return idSponsorRegis;}


    public void setNameSponsorRegis(String nameSponsorRegis) { this.nameSponsorRegis = nameSponsorRegis;}
    public String getNameSponsorRegis() { return nameSponsorRegis ;}


    public void setAmount(String Amount) { this.Amount = Amount;}
    public String getAmount() {return Amount;}






}