import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecipeFeedbackComponent } from './recipe-feedback.component';

describe('RecipeFeedbackComponent', () => {
  let component: RecipeFeedbackComponent;
  let fixture: ComponentFixture<RecipeFeedbackComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecipeFeedbackComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecipeFeedbackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
