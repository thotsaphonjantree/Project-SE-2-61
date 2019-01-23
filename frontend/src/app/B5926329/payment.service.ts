import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) {}

   getPaymentByMember(mid): Observable<any>{
    return this.http.get('//localhost:8080/payment/'+mid);
  }

  getEventById(Eid){
    return this.http.get('//localhost:8080/event/'+Eid);
  }

  getAllPayments(): Observable<any> {
    return this.http.get('//localhost:8080/payments');
  }

  getMembers(): Observable<any>{
    return this.http.get('//localhost:8080/members');
  }

  getAllEvent(): Observable<any>{
    return this.http.get('//localhost:8080/event');
  }

  getAllPayCate(): Observable<any>{
    return this.http.get('//localhost:8080/paycates');
  }


  getMemberById(id){
    return this.http.get('//localhost:8080/member/'+id);
  }

  setMemberLoginId(id){
    localStorage.setItem('key',id);
  }

  getMemberLoginId(){
    return localStorage.getItem('key');
  }

}
