import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Subject } from 'rxjs';
import {AccountTable} from '../table/table.component';

@Injectable({
  providedIn: 'root'
})
export class AccountService {

  dataTemp = new Subject<string>();
  public API = '//localhost:8080';
  private serviceUrl = '//localhost:8080//AccountRecord';

  constructor(private http: HttpClient) { }

  getAccountRecord(): Observable<any> {
    return this.http.get(this.API + '/AccountRecord');
  }
  getBank(): Observable<any> {
    return this.http.get(this.API + '/Banks');
  }
  getFrom(): Observable<any> {
    return this.http.get(this.API + '/FromTo');
  }
  getIncomeExpenses(): Observable<any> {
    return this.http.get(this.API + '/IncomeExpenses');
  }
  getRoom(): Observable<AccountTable[]> {
    return this.http.get<AccountTable[]>(this.serviceUrl);
  }
  getEvent(): Observable<any> {
    return this.http.get(this.API + '/event');
  }
}
