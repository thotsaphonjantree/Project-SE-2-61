import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {PeriodicElement} from '../../B5901890/component/register/register.component';
@Injectable({
  providedIn: 'root'
})
export class RegisterserviceService {
  public API = '//localhost:8080';

  private ServiceUrl = 'http://localhost:8080/RegisterStaff' //getPart จากbackend

  constructor(private http: HttpClient) { }

  getWork(): Observable<any> {
    return this.http.get(this.API + '/workStaff');  //ตรงCollection จากbackend
  }

  getGender(): Observable<any> {
    return this.http.get(this.API + '/genders');
  }
  // getTime(): Observable<any> {
  //   return this.http.get(this.API + '/time');
  // }
  getAge(): Observable<any> {
    return this.http.get(this.API + '/age');
  }

  getRegisterStaff():Observable<any>{
    return this.http.get(this.API + '/RegisterStaff');
  }

  getShow():Observable<PeriodicElement[]>{
    return this.http.get<PeriodicElement[]>(this.ServiceUrl);
  }

}
