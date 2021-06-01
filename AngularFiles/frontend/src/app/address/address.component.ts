import { ProductService } from './../product.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-address',
  templateUrl: './address.component.html',
  styleUrls: ['./address.component.scss']
})
export class AddressComponent implements OnInit, OnDestroy {
  isPost = true;
  user;
  address: any = {
    id_adr: null,
    street: "",
    postcode: "",
    city: "",
    country: ""
  };
  paymentOptions: string[] = ["BLIK","Przelewy24","Dotpay","BITCOIN","Karta kredytowa"];
  paymentMethod = this.paymentOptions[0];
  kraje: string[] = ["Polska","Czechy","Niemcy","Słowacja","Ukraina"];
  exportInfo: any = {
    address: this.address,
    payment: this.paymentMethod
  }
  subscription: Subscription;
  constructor(private authservice: AuthService, private productService: ProductService, private router: Router) { }

  changeAddress(){
    console.log(this.isPost);
    if(this.isPost){
      this.authservice.setAddress({token:this.user.token, city:this.address.city, country:this.address.country, client:this.user.id, postcode:this.address.postcode, street:this.address.street}).subscribe(() =>{
        this.exportInfo= {
          address: this.address,
          payment: this.paymentMethod
        }
        this.newMessage(this.exportInfo)
      })
    }else{
      this.authservice.changeAddress({token:this.user.token, city:this.address.city, country:this.address.country,idadr:this.address.id_adr, client:this.user.id, postcode:this.address.postcode, street:this.address.street}).subscribe(()=>{
        this.exportInfo= {
          address: this.address,
          payment: this.paymentMethod
        }
        this.newMessage(this.exportInfo)
      })
    }
  }
  ngOnInit(): void {
    this.subscription = this.productService.currentMessage.subscribe(message => this.exportInfo = message)
    this.user = JSON.parse(sessionStorage.getItem('token'));
    this.authservice.getAddress(this.user).subscribe(data =>{

      if(data.body != ""){
        this.address= JSON.parse(data.body);
        this.isPost = false;
      }
    });
  }
  newMessage(data) {
    this.productService.changeMessage(data);
    this.router.navigate(["checkout"])
  }

  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
