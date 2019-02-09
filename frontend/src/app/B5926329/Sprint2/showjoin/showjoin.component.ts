import { Component, OnInit } from '@angular/core';
import { JoineventService } from '../../joinevent.service';
import { LoginmemberService } from '../../loginmember.service';

@Component({
  selector: 'app-showjoin',
  templateUrl: './showjoin.component.html',
  styleUrls: ['./showjoin.component.css']
})
export class ShowjoinComponent implements OnInit {

  constructor(private data:JoineventService,private loginmemberService:LoginmemberService) { }

  joins:Array<any>;

  ngOnInit() {
    this.data.getJoineventByMember(this.loginmemberService.getMemberLoginId()).subscribe(
      data => {this.joins = data})
  }

}
