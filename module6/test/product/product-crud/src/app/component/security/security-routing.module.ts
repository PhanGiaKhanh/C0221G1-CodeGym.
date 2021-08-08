import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {LoginComponent} from './login/login.component';


const routes: Routes = [
  {path: 'login', component: LoginComponent},
  // {path:'verification',component: VerificationComponent},
  // {path:'reset-password',component: ResetPasswordComponent},
  // {path:'verify-reset-password',component: VerifyResetPasswordComponent},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SecurityRoutingModule {
}
