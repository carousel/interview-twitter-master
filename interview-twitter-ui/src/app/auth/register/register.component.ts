import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthService} from '../../services/auth.service';
import {NgForm} from '@angular/forms';
import {TweetService} from '../../services/tweet/tweet.service';

@Component({
  moduleId: module.id,
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css'],
  selector: 'app-register',
})

export class RegisterComponent {
  model: any = {firstName: '', lastName: '', username: '', password: ''};
  loading = false;
  incorrectCredentialsError = false;

  constructor(private router: Router, private tweetService: TweetService,  private authService: AuthService) {
  }

  onSubmit(registerForm: NgForm): void {
    if (registerForm.valid) {
      this.authService.generateAuthTokenForRegistration(registerForm.value.username, registerForm.value.password);
      this.tweetService.register(registerForm.value);
      this.authService.logout();
      // this.router.navigate(['/login']);
    }
  }

  isFormSubmittedWithInvalidFirstName(loginForm: NgForm): boolean {
    const firstNameFormControl = loginForm.form.controls['firstName'];
    return loginForm.submitted && firstNameFormControl && !firstNameFormControl.valid;
  }

  isFormSubmittedWithInvalidLastName(loginForm: NgForm): boolean {
    const lastNameFormControl = loginForm.form.controls['lastName'];
    return loginForm.submitted && lastNameFormControl && !lastNameFormControl.valid;
  }

  isFormSubmittedWithInvalidUsername(loginForm: NgForm): boolean {
    const usernameFormControl = loginForm.form.controls['username'];
    return loginForm.submitted && usernameFormControl && !usernameFormControl.valid;
  }

  isFormSubmittedWithInvalidPassword(loginForm: NgForm): boolean {
    const passwordFormControl = loginForm.form.controls['password'];
    return loginForm.submitted && passwordFormControl && !passwordFormControl.valid;
  }
}
