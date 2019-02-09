import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SeeStoreComponent } from './see-store.component';

describe('SeeStoreComponent', () => {
  let component: SeeStoreComponent;
  let fixture: ComponentFixture<SeeStoreComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SeeStoreComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SeeStoreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
