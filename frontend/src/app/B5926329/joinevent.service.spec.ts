import { TestBed } from '@angular/core/testing';

import { JoineventService } from './joinevent.service';

describe('JoineventService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: JoineventService = TestBed.get(JoineventService);
    expect(service).toBeTruthy();
  });
});
