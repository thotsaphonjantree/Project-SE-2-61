import { TestBed, inject } from '@angular/core/testing';

import { ReservePlaceService } from './reserve-place.service';

describe('ReservePlaceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [ReservePlaceService]
    });
  });

  it('should be created', inject([ReservePlaceService], (service: ReservePlaceService) => {
    expect(service).toBeTruthy();
  }));
});
