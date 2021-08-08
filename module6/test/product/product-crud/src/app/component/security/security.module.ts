import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {SecurityRoutingModule} from './security-routing.module';
import {LoginComponent} from './login/login.component';
import {HttpClientModule} from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({
  declarations: [
    LoginComponent,
    // RegisterComponent,
    // VerificationComponent,
    // ResetPasswordComponent,
    // VerifyResetPasswordComponent
  ],
  imports: [
    CommonModule,
    SecurityRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    // ToastrModule.forRoot(),
    BrowserAnimationsModule
  ]
})
export class SecurityModule {
}
