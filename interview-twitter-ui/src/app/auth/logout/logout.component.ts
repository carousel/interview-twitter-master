import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {AuthService} from '../../services/auth.service';

@Component({
  moduleId: module.id,
  template: '',
  selector: 'app-logout',
})

export class LogoutComponent implements OnInit {
  constructor(private router: Router, private authService: AuthService) {}
  ngOnInit() {
    this.authService.logout();
    this.router.navigate(['login']);
  }

}

