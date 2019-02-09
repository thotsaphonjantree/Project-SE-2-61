import { Component, OnInit } from '@angular/core';
import { AccountService } from '../service/account.service';
import { Observable } from 'rxjs/Observable';
import { DataSource } from '@angular/cdk/collections';

export interface AccountTable {
  idaccount: number;
  savedate: string;
  title: string;
  banks: {
    nameBank: string;
  };
  incomeExpenses:{
    incomeExpenses: string;
  }
  SportsEvent:{
    eventname: string;
  }
  FromTo: {
    nameFromTo: string;
  };
  amount: string;
}
@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css']
})
export class TableComponent implements OnInit {

  displayedColumns: string[] = ['idaccount', 'savedate', 'title', 'incomeexpenses', 'nameBank', 'fromto', 'amount' ,'eventname'];
  dataSource = new Account(this.accountService);
  constructor(private accountService: AccountService) { }

  ngOnInit() {
  }

}

export class Account extends DataSource<any> {
  constructor(private accountService: AccountService) {
    super();
  }
  connect(): Observable<AccountTable[]> {
    return this.accountService.getRoom();
  }
  disconnect() {}
}
