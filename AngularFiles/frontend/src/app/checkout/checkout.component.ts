import { ToastrService } from 'ngx-toastr';
import { ProductService } from './../product.service';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.scss']
})
export class CheckoutComponent implements OnInit, OnDestroy {
  shippingInfo: any;
  cart: any;
  exportcart: any[]= [];
  price : number;
  subscription: Subscription;
  user;
  constructor(private productService: ProductService, private toastr: ToastrService, private router: Router) { }

  ngOnInit(): void {
    this.user = JSON.parse(sessionStorage.getItem('token'));
    this.cart = JSON.parse(sessionStorage.getItem('cart'));
    this.price = this.calcValue();
    this.price = Math.round(this.price*100)/100;
    for (let item in this.cart) {
      this.exportcart.push({id_pro:this.cart[item].id,quantity:this.cart[item].qty})
    }
    this.subscription = this.productService.currentMessage.subscribe(message => {
      this.shippingInfo = message;
    })
  }
  buy(){
    this.productService.makeOrder({client:this.user.id, token:this.user.token, city:this.shippingInfo.address.city, country:this.shippingInfo.address.country, paymentMethod:this.shippingInfo.payment, postcode:this.shippingInfo.address.postcode, price:this.price, street:this.shippingInfo.address.street},this.exportcart).subscribe(data=>{
      if(data.status==201){
        this.toastr.success("Zamówienie zostało złożone! Dziekujemy!","Sukces!")
        sessionStorage.setItem('cart','[]');
        this.router.navigate([""]);

      }
    });
  }
  calcValue(){
    let sum=0;
    for(let item of this.cart){
      sum+=item.price * item.qty;
    }
    return sum
  }
  ngOnDestroy() {
    this.subscription.unsubscribe();
  }

}
