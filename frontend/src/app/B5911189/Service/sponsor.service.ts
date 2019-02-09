import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Subject} from "rxjs";
import {SponsorTable} from "../stable/stable.component";


@Injectable({
  providedIn: 'root'
})
export class SponsorService {
  dataTemp = new Subject<string>();
  public API = '//localhost:8080';
  private serviceUrl = '//localhost:8080//SponsorRegis';


  constructor(private http: HttpClient) {
  }
  getAll(): Observable<any> {
    return this.http.get('//localhost:8080//SponsorRegis');
  }

  getTransfer(): Observable<any> {
    return this.http.get(this.API + '/Transfer');
  }
  getStatus(): Observable<any> {
    return this.http.get(this.API + '/SponsorStatus');
  }
  getRoom(): Observable<SponsorTable[]> {
    return this.http.get<SponsorTable[]>(this.serviceUrl);
  }
}
