import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { PaymentService } from '../payment.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-memberlogin',
  templateUrl: './memberlogin.component.html',
  styleUrls: ['./memberlogin.component.css']
})
export class MemberloginComponent implements OnInit {

  members:Array<any>;
  checkround:Number;


  constructor(private paymentService:PaymentService,private router: Router) { }

  ngOnInit() {
    this.paymentService.getMembers().subscribe(data => {
      this.members = data;
      })
  }

  
  loginUser(event){
    event.preventDefault()
    const target = event.target
    const username = target.querySelector('#username').value
    const password = target.querySelector('#password').value

    for(let i=0 ; i< this.members.length; i++)
    {
        if (this.members[i].username === username && this.members[i].password === password)
        {
            this.checkround = 1;
            console.log("User Found" , this.members[i]);
            this.paymentService.setMemberLoginId(this.members[i].memberId);
            break;
        }
        else
        this.checkround = 0;
    }

    if(this.checkround === 1){
      alert("Login Success");
          this.router.navigate(['payment']);
        }
      else
      alert("Username/Password is Invalid");

  }


}
