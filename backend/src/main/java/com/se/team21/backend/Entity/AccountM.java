package th.sut.sa.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity  //บอกว่าเป็น class entity class ที่เก็บขอมูล
@Data  // lombox จะสร้าง method getter setter ให้เอง
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class AccountRecord {
    @Id  //  Annotations  @Id  บอกว่าเป็น  Primary  key
    @SequenceGenerator(name = "account_seq", sequenceName = "account_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @Column(name = "idaccount", unique = true, nullable = false)
    private @NonNull Long idaccount;
    private @NonNull String Title;
    private @NonNull String Incomeexpense;
    private @NonNull String Form;
    private @NonNull String Bank;
    private @NonNull String amount;
}