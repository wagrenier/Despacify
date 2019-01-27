import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ResultStatComponent } from './result-stat.component';

describe('ResultStatComponent', () => {
  let component: ResultStatComponent;
  let fixture: ComponentFixture<ResultStatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ResultStatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ResultStatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
