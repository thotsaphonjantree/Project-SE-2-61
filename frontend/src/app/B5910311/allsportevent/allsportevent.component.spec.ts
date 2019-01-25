import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllsporteventComponent } from './allsportevent.component';

describe('AllsporteventComponent', () => {
  let component: AllsporteventComponent;
  let fixture: ComponentFixture<AllsporteventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllsporteventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllsporteventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
