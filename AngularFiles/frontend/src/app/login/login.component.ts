
import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  model: any = {};
  isLogged: boolean = false;
  constructor(private router: Router, private authservice: AuthService, ) { }
  login(){
      this.authservice.getLogin(this.model).subscribe((data)=>{
        if(data.status == 200){
          let auth = JSON.parse(data.body);
          sessionStorage.setItem('token',JSON.stringify({token:auth.authKey, id: auth.id_client, logged: true}))
          this.authservice.setLogin(true);
          this.router.navigate([""])
        }
    },
    () =>{

    });
    //logowanie
    //1. dane z modelu wysyłam do geta
    //2. get odpowiada 200  (authkey i id) albo 500
    //jesli 200 to zapisz do sesji jeśli nie to nie

  }
  ngOnInit(): void {
    this.authservice.checkLogin().subscribe(data => this.isLogged = data)
  }


}
