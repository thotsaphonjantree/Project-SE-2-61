import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowjoinComponent } from './showjoin.component';

describe('ShowjoinComponent', () => {
  let component: ShowjoinComponent;
  let fixture: ComponentFixture<ShowjoinComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ShowjoinComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ShowjoinComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
