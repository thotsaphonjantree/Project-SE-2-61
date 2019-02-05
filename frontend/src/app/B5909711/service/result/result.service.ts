import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import 'rxjs/add/operator/map';
import { Subject } from 'rxjs';
import { Observable } from 'rxjs/Observable';
import {PeriodicElement} from '../../component/result/result.component';

@Injectable({
  providedIn: 'root'
})
export class ResultService {
  dataTemp = new Subject<String>();
  public API = '//localhost:8080';
  private serviceUrl = 'http://localhost:8080/Result';
  private serviceUrl2 = 'http://localhost:8080/Results/'
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

  getRatingName(): Observable<any> {
    return this.http.get(this.API + '/Rating')
  }

  getPersonTypeName(): Observable<any> {
    return this.http.get(this.API + '/PersonType')
  }

  getShow():Observable<PeriodicElement[]>{
    return this.http.get<PeriodicElement[]>(this.serviceUrl);
  }

  getSelectShow(activity: string):Observable<any>{
    return this.http.get(this.serviceUrl2 + activity);
  }
}
