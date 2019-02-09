import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {PeriodicElement} from '../component/registerMedia/registermedia.component';
@Injectable({
  providedIn: 'root'
})
export class RegisterserMviceService {
  public API = '//localhost:8080';

  private ServiceUrl = 'http://localhost:8080/RegisterMedia' //getPart จากbackend

  constructor(private http: HttpClient) { }

  getKindMedia(): Observable<any> {
    return this.http.get(this.API + '/kindMedia');  //ตรงCollection จากbackend
  }

  getGender(): Observable<any> {
    return this.http.get(this.API + '/genders');
  }

  getKindSportMedia(): Observable<any> {
    return this.http.get(this.API + '/kindSportMedia');
  }

  getRegisterMedia():Observable<any>{
    return this.http.get(this.API + '/RegisterMedia');
  }


  getShow():Observable<PeriodicElement[]>{
    return this.http.get<PeriodicElement[]>(this.ServiceUrl);
  }

}
