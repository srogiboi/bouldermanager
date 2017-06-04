/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { AscentsComponent } from './ascents.component';

describe('AscentsComponent', () => {
  let component: AscentsComponent;
  let fixture: ComponentFixture<AscentsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AscentsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AscentsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
