import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SporteventService } from '../sportevent.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profiledetail',
  templateUrl: './profiledetail.component.html',
  styleUrls: ['./profiledetail.component.css']
})
export class ProfiledetailComponent implements OnInit {

  profile:Array<any>;
  constructor(private sporteventService: SporteventService, private httpClient: HttpClient,private route: ActivatedRoute) { 
  }

  ngOnInit() {
    this.sporteventService.showAllProfile().subscribe(data => {this.profile = data;})
    
  }

}
