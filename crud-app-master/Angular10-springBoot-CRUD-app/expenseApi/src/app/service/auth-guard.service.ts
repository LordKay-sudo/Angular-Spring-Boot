import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { AuthService } from './authentication.service';
import {LoginComponent} from '../login/login.component'

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate {

  constructor(private router: Router,
    private authService: AuthService,
    private loginComponent: LoginComponent) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
      if (this.loginComponent.isLoggedIn)
        return true;
  
      this.router.navigate(['login']);
      return false;
  
    }
}
