import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import { LoginmemberService } from '../loginmember.service';

@Component({
  selector: 'app-checkstatus',
  templateUrl: './checkstatus.component.html',
  styleUrls: ['./checkstatus.component.css']
})
export class CheckstatusComponent implements OnInit {

  mid:any;

  payments:Array<any>;

  constructor(private data:PaymentService,private loginmemberService:LoginmemberService) {


  }

  ngOnInit() {
    this.data.getPaymentByMember(JSON.parse(localStorage.getItem('member')).memberId).subscribe(
      data => {this.payments = data})

  }
  
}
