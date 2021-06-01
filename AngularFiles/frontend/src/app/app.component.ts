import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'PUERTO LEGO';


  ngOnInit(): void {
    if(sessionStorage.getItem('cart') == null){
      sessionStorage.setItem('cart',JSON.stringify([]));
    }
    if(sessionStorage.getItem('token') == null){
      sessionStorage.setItem('token',JSON.stringify({token: "", id: null, logged: false}));
    }
  }
}
