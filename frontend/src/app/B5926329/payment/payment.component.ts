import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  constructor(private data:PaymentService,private httpClient:HttpClient,private router:Router) { }

  events: Array<any>;
  memberLogin:any;
  paycates: Array<any>;

  pay : any = {
    eventname:'',
    paycatename:'',
    paid:'',
    username:''
  }

  checkevent : any;

  ngOnInit() {

      this.data.getAllEvent().subscribe(data => {
      this.events = data;
      })
    
      this.data.getAllPayCate().subscribe(data => {
      this.paycates = data;
      })

      this.data.getMemberById(this.data.getMemberLoginId()).subscribe(
        data => { this.memberLogin = data})

  }


  save(){

    this.data.getEventById(this.pay.eventname).subscribe(
      data => { this.checkevent = data})

    if(this.pay.eventname === '' || this.pay.paycatename === '' || this.pay.paid === '' || this.memberLogin.username === '')
    alert('กรอกข้อมูลให้ครบถ้วน');
    else if(this.pay.paid == this.checkevent.price){
      alert('จ่ายเงินสำเร็จ !!');
      this.httpClient.post('http://localhost:8080/payment/save/',this.pay).subscribe(
        data => {
            console.log('POST Request is successful', data);
        },
        error => {
            console.log('Error', error);
        })
        this.router.navigate(['checkstatus/']);
        window.location.reload();
      }
    else{
      alert('กรอกจำนวนเงินให้ถูกต้อง');
}
  }

  price(price){
    return this.price;
  }
}
  
