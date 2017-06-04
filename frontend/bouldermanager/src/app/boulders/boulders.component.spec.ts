/* tslint:disable:no-unused-variable */
import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { BouldersComponent } from './boulders.component';

describe('BouldersComponent', () => {
  let component: BouldersComponent;
  let fixture: ComponentFixture<BouldersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BouldersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BouldersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
