import { Component, OnInit } from '@angular/core';
import { PaymentService } from '../payment.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-checkstatus',
  templateUrl: './checkstatus.component.html',
  styleUrls: ['./checkstatus.component.css']
})
export class CheckstatusComponent implements OnInit {

  mid:any;

  payment:Object;
  constructor(private data:PaymentService,private route:ActivatedRoute) {
    this.route.params.subscribe( params => this.payment = params.mid)
  }

  ngOnInit() {
        this.data.getPaymentByMember(this.payment).subscribe(
          data => this.payment = data
          )
  }

}
