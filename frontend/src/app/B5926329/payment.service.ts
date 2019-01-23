import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) {}

   getPaymentByMember(mid){
    return this.http.get('//localhost:8080/payment/'+mid);
  }

  getAllPayments(): Observable<any> {
    return this.http.get('//localhost:8080/payments');
  }
}
