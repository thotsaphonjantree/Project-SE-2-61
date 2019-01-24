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

public class IncomeExpenses {
    @Id
    @SequenceGenerator(name="IncomeExpenses_seq",sequenceName="IncomeExpenses_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="IncomeExpenses_seq")
    @Column(name="idIncomeExpenses",unique = true, nullable = false)
    private @NonNull Long idIncomeExpenses;
    private @NonNull String incomeExpenses;


    public void setIdIncomeExpenses(Long idIncomeExpenses) {
        this.idIncomeExpenses = idIncomeExpenses;
    }
    public Long getIdIncomeExpenses() {
        return idIncomeExpenses;
    }

    public void setIncomeExpenses(String incomeExpenses) {
        this.incomeExpenses = incomeExpenses;
    }
    public String getIncomeExpenses() {
        return incomeExpenses;
    }

}