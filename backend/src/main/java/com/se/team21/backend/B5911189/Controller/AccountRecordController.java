package com.se.team21.backend.B5911189.Controller;
import com.se.team21.backend.B5911189.Repository.*;
import com.se.team21.backend.B5911189.Entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins =  "http://localhost:4200")
public class AccountRecordController {
    @Autowired  private  AccountRecordRepository accountrecordrepository;
    @Autowired  private  BankRepository bankRepository;
    @Autowired  private  FromToRepository fromToRepository;
    @Autowired  private  IncomeExpensesRepository incomeExpensesRepository;

    @Autowired AccountRecordController (AccountRecordRepository accountrepo){
        this.accountrecordrepository = accountrepo;
    }
    @GetMapping(path="/AccountRecord",produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<AccountRecord> AccountRecord(){
        return accountrecordrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping(path = "/AccountRecord/{Time}/{Title}/{Income}/{Bank}/{fromto}/{Amount}")
    public AccountRecord accountrecord(@PathVariable Date Time,
                                       @PathVariable String Title, @PathVariable String Income,
                                       @PathVariable String Bank, @PathVariable String fromto,
                                       @PathVariable String Amount){

        AccountRecord a = new AccountRecord();

        Banks b = bankRepository.findBynameBank(Bank);
        System.out.println(Bank);

        FromTo f = fromToRepository.findBynameFromTo(fromto);
        System.out.println(fromto);

        IncomeExpenses inout = incomeExpensesRepository.findByIncomeExpenses(Income);
        System.out.println(Income);

        a.setSavedate(Time);
        a.setTitle(Title);
        a.setIncomeExpenses(inout);
        a.setBanks(b);
        a.setFromto(f);

        a.setAmount(Amount);

        return accountrecordrepository.save(a);


    }



}