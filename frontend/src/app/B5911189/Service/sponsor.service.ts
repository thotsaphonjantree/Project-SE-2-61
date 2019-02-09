import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Subject} from "rxjs";


@Injectable({
  providedIn: 'root'
})
export class SponsorService {
  dataTemp = new Subject<string>();
  public API = '//localhost:8080';


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
}
