import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeePlaceXComponent } from './see-place-x.component';

describe('SeePlaceXComponent', () => {
  let component: SeePlaceXComponent;
  let fixture: ComponentFixture<SeePlaceXComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeePlaceXComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeePlaceXComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
