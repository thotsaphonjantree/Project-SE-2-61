import { TestBed, inject } from '@angular/core/testing';

import { SporteventService } from './sportevent.service';

describe('SporteventService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [SporteventService]
    });
  });

  it('should be created', inject([SporteventService], (service: SporteventService) => {
    expect(service).toBeTruthy();
  }));
});
