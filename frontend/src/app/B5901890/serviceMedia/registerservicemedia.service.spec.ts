import { TestBed, inject } from '@angular/core/testing';

import { RegisterserMviceService } from './registerservicemedia.service';

describe('RegisterserviceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RegisterserMviceService]
    });
  });

  it('should be created', inject([RegisterserMviceService], (service: RegisterserMviceService) => {
    expect(service).toBeTruthy();
  }));
});
