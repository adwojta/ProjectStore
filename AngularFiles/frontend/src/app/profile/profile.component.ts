import { ProductService } from './../product.service';
import { WishlistService } from './../wishlist.service';
import { AuthService } from './../auth.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  model: any = {
    token: "",
    id: null,
    name: "",
    surname:""
  };
  pass = {old: "", new: ""};
  history: any = [];
  wishes: any;
  constructor(private router: Router, private authservice: AuthService, private wishlist:WishlistService,private productService: ProductService,private toastr: ToastrService) { }
  logOut(){
    this.authservice.setLogin(false);
    sessionStorage.setItem('token',JSON.stringify({token: "", id: null, logged: false}));
    this.router.navigate([""])

  }
  changeInfo(){
    this.authservice.changeInfo(this.model).subscribe((data)=>{
      if(data.status == 200){
        this.toastr.success("Pomyślnie zmieniono dane osobowe!","Sukces!");
      }
    });
  }
  changePassword(){
    this.authservice.changePass({token: this.model.token, id: this.model.id, old: this.pass.old, new: this.pass.new}).subscribe((data)=>{
      if(data.status == 200){
        this.toastr.success("Pomyślnie zmieniono hasło!","Sukces!");
      }
    });
  }
  ngOnInit(): void {
    let client = JSON.parse(sessionStorage.getItem('token'));
    console.log(client)
    this.authservice.getInfo(client).subscribe(data => {
      let user = JSON.parse(data.body);
      this.model = {token: client.token,
      id: client.id,
      name: user.name,
      surname: user.surname};
    });

    this.productService.getOrders(client).subscribe( data => {
      this.history = data.body;

    });

    this.wishlist.getWishList(client).subscribe(data => {
      this.wishes = data.body;
    },
    ()=>{},
    ()=>{});

  }

}
