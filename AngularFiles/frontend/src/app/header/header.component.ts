import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  isLogged: boolean;
  constructor(private authservice: AuthService) { }

  ngOnInit(): void {

    this.authservice.checkLogin().subscribe(data => this.isLogged = data);
    this.isLogged = JSON.parse(sessionStorage.getItem('token')).logged;
  }

}
