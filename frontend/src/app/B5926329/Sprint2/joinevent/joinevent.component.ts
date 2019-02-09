import { Component, OnInit } from '@angular/core'
import { JoineventService } from '../../joinevent.service';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import { LoginmemberService } from '../../loginmember.service';


@Component({
  selector: 'app-jointevent',
  templateUrl: './joinevent.component.html',
  styleUrls: ['./joinevent.component.css']
})
export class JoineventComponent implements OnInit {

  expertlevels: Array<any>;
  events: Array<any>;
  memberLogin:any;
  genderJoins:Array<any>;

  constructor(private data:JoineventService,private httpClient:HttpClient,private loginmemberService:LoginmemberService,
              private router:Router) { }

  join : any = {
      userId : '',
      eventId : '',
      expertlevelId : '',
      tel:'',
      tagName:'',
      personalId:'',
      genderId:''

  }

text : String = ''

  ngOnInit() {

      this.data.getAllEvent().subscribe(data => {
        this.events = data;
      })

      this.data.getAllGenders().subscribe(data => {
        this.genderJoins = data;
          })


      this.data.getMemberById(this.loginmemberService.getMemberLoginId()).subscribe(
        data => { this.memberLogin = data})

      this.data.getAllExpertLevel().subscribe(data => {
        this.expertlevels = data;
          })
  }

  save(){

    if(this.join.userId  === '' || this.join.eventId  === '' || this.join.expertlevelId  === '' ||
      this.join.tel  === '' || this.join.tagName  === '' || this.join.personalId  === '' || this.join.genderId  === ''  )
      //alert("กรุณากรอกข้อมูลให้ครบถ้วน");
      this.text = "กรุณากรอกข้อมูลให้ครบถ้วน"
    else
    this.httpClient.post('http://localhost:8080/joinevent/save',this.join).subscribe(
      data => {
          console.log('POST Request is successful', data);
          //alert('ลงทะเบียนสำเร็จ');
          this.text = "ลงทะเบียนสำเร็จ"
      },
      error => {
        //alert('กรอกข้อมูลผิดพลาด');
        this.text = "กรอกข้อมูลผิดพลาด"
          console.log('Error', error);
      })
      
      //this.router.navigate(['showjoin/']);
      //window.location.reload();

    }

  


}
