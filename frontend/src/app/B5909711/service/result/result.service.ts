import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class ResultService {
  dataTemp = new Subject<String>();
  public API = '//localhost:8080';

  constructor(private http: HttpClient) { }

  getActivitiesName(): Observable<any> {
    return this.http.get(this.API + '/event');
  }

  getSportstype(): Observable<any> {
    return this.http.get(this.API + '/sportstype');
  }

  getProvinceName(): Observable<any> {
    return this.http.get(this.API + '/Province');
  }

}
