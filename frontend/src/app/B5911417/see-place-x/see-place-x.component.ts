import { Component, OnInit } from '@angular/core';
import { ReservePlaceService } from '../reserve-place.service';
import { HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-see-place-x',
  templateUrl: './see-place-x.component.html',
  styleUrls: ['./see-place-x.component.css']
})
export class SeePlaceXComponent implements OnInit {

  reserveInfo: Array<any>;

  constructor(private httpClient: HttpClient, private reservePlaceService: ReservePlaceService) { }

  ngOnInit() {


    this.reservePlaceService.showAllReserve().subscribe(data => {
      this.reserveInfo = data;
      });
}

  }

