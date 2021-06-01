import { ToastrService } from 'ngx-toastr';
import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  model: any = {};

  constructor(private authservice: AuthService, private toastr: ToastrService) { }
  register(){
    this.authservice.createUser(this.model).subscribe((data)=>{
      if(data.status == 201){
        this.toastr.success("Stworzono nowe konto! Możesz sie teraz zalogować!","Sukces!")
      }
    });
  }

  ngOnInit(): void {

}
}
