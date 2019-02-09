
import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { AccountService } from '../service/account.service';

@Component({
  selector: 'app-account',
  templateUrl: './account.component.html',
  styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {
  recordEvent: Array<any>;
  recordINOUT: Array<any>;
  recordBank: Array<any>;
  recordType: Array<any>;
  // startDate = new Date(1990, 0, 1);
  views: any = {
    inputTime: null,
    title: null,
    incomeSelect: null,
    bankSelect: null,
    fromSelect: null,
    eventSelect: null,
    amount: null
  };

  constructor(private accountService: AccountService, private httpClient: HttpClient) {
  }

  ngOnInit() {
    this.accountService.getIncomeExpenses().subscribe(data => {
      this.recordINOUT = data;
      console.log(this.recordINOUT);
    });

    this.accountService.getBank().subscribe(data => {
      this.recordBank = data;
      console.log(this.recordBank);
    });

    this.accountService.getFrom().subscribe(data => {
      this.recordType = data;
      console.log(this.recordType);
    });
    this.accountService.getEvent().subscribe(data => {
      this.recordEvent = data;
      console.log(this.recordEvent);
    });

  }
    Save() {
      if (this.views.inputTime == null) {
        alert('กรุณากรอกวันที่');
      } else if (this.views.title == null) {
        alert('กรุณากรอกรายการ');
      } else if (this.views.eventSelect == null) {
        alert('กรุณาระบุรกิจกรรมกีฬา');
      }else if (this.views.incomeSelect == null) {
        alert('กรุณาระบุรายรับ/รายจ่าย');
      } else if (this.views.bankSelect == null) {
        alert('กรุณาระบุธนาคาร');
      } else if (this.views.fromSelect == null) {
        alert('กรุณาระบุรูปแบบการเงิน');
      } else if (this.views.amount == null || this.views.amount == "" ) {
        alert('กรุณากรอกจำนวนเงิน');
      } else {
        this.SaveData();

      }
    }
      SaveData() {
        this.httpClient.get('http://localhost:8080/AccountRecord/'+ this.views.inputTime+ '/' + this.views.title + '/'
        + this.views.incomeSelect + '/' + this.views.bankSelect + '/' + this.views.fromSelect + '/' + this.views.amount  + '/' + this.views.eventSelect , this.views)
          .subscribe(
            data => {
              console.log('PUT Request is successful', data);
              alert('บันทึกเรียบร้อย');
            },
            error => {
              console.log(this.views.inputTime);
              console.log(this.views.title);
              console.log(this.views.incomeSelect);
              console.log(this.views.bankSelect);
              console.log(this.views.fromSelect);
              console.log(this.views.amount);
              console.log(this.views.eventSelect);
              console.log('Error', error);
              alert('บันทึกไม่สำเร็จ ข้อมูลผิดพลาด');
            }
          );
  }



}


