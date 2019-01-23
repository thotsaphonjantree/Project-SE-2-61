import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';

@Component({
  selector: 'app-checkstatus',
  templateUrl: './checkstatus.component.html',
  styleUrls: ['./checkstatus.component.css']
})
export class CheckstatusComponent implements OnInit {

  mid:any;

  payments:Array<any>;

  constructor(private data:PaymentService) {


  }

  ngOnInit() {
    this.data.getPaymentByMember(this.data.getMemberLoginId()).subscribe(
      data => {this.payments = data})

  }
  
}
