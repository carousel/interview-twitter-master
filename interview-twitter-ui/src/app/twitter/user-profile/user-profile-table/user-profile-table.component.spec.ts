import {async, ComponentFixture, TestBed} from '@angular/core/testing';
import {UserProfileTableComponent} from "./user-profile-table.component";

describe('UserProfileTableComponent', () => {
  let component: UserProfileTableComponent;
  let fixture: ComponentFixture<UserProfileTableComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [UserProfileTableComponent]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserProfileTableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
