import { Component, OnInit } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { PaymentService } from '../payment.service';
import { Router } from '@angular/router';
import { LoginmemberService } from '../loginmember.service';


@Component({
  selector: 'app-memberlogin',
  templateUrl: './memberlogin.component.html',
  styleUrls: ['./memberlogin.component.css']
})
export class MemberloginComponent implements OnInit {

  members:Array<any>;
  checkround:Number;
  text : String = ''

  constructor(private paymentService:PaymentService,private router: Router,private loginmemberService: LoginmemberService) { }

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
            this.loginmemberService.setMemberLoginId(this.members[i].memberId);
            break;
        }
        else
        this.checkround = 0;
    }

    if(this.checkround === 1){
      alert("Login Success");
          this.router.navigate(['joinevent']);
        }
      else
      //alert("Username/Password is Invalid");
      this.text = "กรอกข้อมูลให้ถูกต้อง !!"
  }


}
