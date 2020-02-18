import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginContainerComponent} from './login-container/login-container.component';
import {LogoutComponent} from './logout/logout.component';

const routes: Routes = [
  {
    path: '',
    component: LoginContainerComponent,
  },
  {
    path: 'logout',
    component: LogoutComponent
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class AuthRoutingModule {
}
