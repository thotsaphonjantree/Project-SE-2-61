import { Component, OnInit ,Input} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { SporteventService } from '../sportevent.service';
import { PARAMETERS } from '@angular/core/src/util/decorators';
import { ActivatedRoute } from '@angular/router';
@Component({
  selector: 'app-allsportevent',
  templateUrl: './allsportevent.component.html',
  styleUrls: ['./allsportevent.component.css']
})
export class AllsporteventComponent implements OnInit {
  sest: Array<any>;
  event: Array<any>;
  constructor(private sporteventService: SporteventService, private httpClient: HttpClient) {
  }
  ngOnInit() {
      this.sporteventService.showAllSportsEvent().subscribe(data => {this.event = data;})
  }

}
