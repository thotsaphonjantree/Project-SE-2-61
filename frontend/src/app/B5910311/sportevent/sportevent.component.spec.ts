import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SporteventComponent } from './sportevent.component';

describe('SporteventComponent', () => {
  let component: SporteventComponent;
  let fixture: ComponentFixture<SporteventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SporteventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SporteventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
