import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SporteventService } from '../sportevent.service';
import { ActivatedRoute } from '@angular/router';



@Component({
  selector: 'app-eventdetail',
  templateUrl: './eventdetail.component.html',
  styleUrls: ['./eventdetail.component.css']
})
export class EventdetailComponent implements OnInit {
  detail:object;
  constructor(private sporteventService: SporteventService, private httpClient: HttpClient,private route: ActivatedRoute) { 
    this.route.params.subscribe( params => this.detail = params.seid)
    
  }

  ngOnInit() {
    this.sporteventService.showEventById(this.detail).subscribe(data => {this.detail = data;})
  }

}
