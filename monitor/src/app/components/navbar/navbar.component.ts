import { Component, Inject, OnInit } from '@angular/core';
import { AuthService } from '@auth0/auth0-angular';
import { IdentityService } from 'src/app/services/identity.service';
import { DOCUMENT } from '@angular/common';
import { faUser, faPowerOff } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {
  isCollapsed = true;
  faUser = faUser;
  faPowerOff = faPowerOff;


  constructor(public auth:AuthService, @Inject(DOCUMENT) private doc:Document,
   public identitySvc:IdentityService) { }

  ngOnInit(): void {
  }

  loginWithRedirect() {
    this.auth.loginWithRedirect();
  }

  logout() {
    this.auth.logout({ returnTo: this.doc.location.origin });
  }

}
