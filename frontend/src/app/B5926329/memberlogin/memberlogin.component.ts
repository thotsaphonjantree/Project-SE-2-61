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

  text : String = ''

  membernoti: boolean;


  credentials = {username: '', password: ''};

  constructor(private paymentService:PaymentService,private router: Router,private loginmemberService: LoginmemberService) { }

  ngOnInit() {


  }

  LoginSubmit() {
    this.loginmemberService.MemberLogin(this.credentials.username.trim(), this.credentials.password.trim()).subscribe(datalogin => {
        if ( datalogin['success'] ) {
          this.loginmemberService.authenticatedmember = true;
            localStorage.setItem('member', JSON.stringify(datalogin['member']));
            this.router.navigate(['joinevent']);
            this.membernoti = true;
            this.text  = 'เข้าสู่ระบบสำเร็จ';
        } else {
          this.membernoti = false;
          this.text = 'กรอกข้อมูลให้ถูกต้อง !!';
          this.loginmemberService.authenticatedmember = false;
          this.router.navigate(['/memberlogin']);
        }
    }, error => {
         this.membernoti = false;
         this.text = 'กรอกข้อมูลให้ถูกต้อง !!';
    });
  }


}
