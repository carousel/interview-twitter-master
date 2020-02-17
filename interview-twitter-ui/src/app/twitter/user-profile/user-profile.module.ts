import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule} from "@angular/router";
import {UserProfileContainerComponent} from "./user-profile-container/user-profile-container.component";
import {UserProfileViewComponent} from "./user-profile-view/user-profile-view.component";
import {UserProfileTableComponent} from "./user-profile-table/user-profile-table.component";

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: '', component: UserProfileContainerComponent, children: [
          {path: '', component: UserProfileViewComponent},
        ],
      },
    ]),
    CommonModule
  ],
  declarations: [UserProfileContainerComponent, UserProfileViewComponent, UserProfileTableComponent],
})
export class UserProfileModule {
}
