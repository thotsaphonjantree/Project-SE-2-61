import { TestBed } from '@angular/core/testing';

import { LoginmemberService } from './loginmember.service';

describe('LoginmemberService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LoginmemberService = TestBed.get(LoginmemberService);
    expect(service).toBeTruthy();
  });
});
