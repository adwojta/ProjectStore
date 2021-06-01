import { ToastrService } from 'ngx-toastr';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-basket',
  templateUrl: './basket.component.html',
  styleUrls: ['./basket.component.scss']
})
export class BasketComponent implements OnInit {
   cart: any[] = [{}];
  value;
  constructor(private router: Router, private toastr: ToastrService) { }

  ngOnInit(): void {
    this.cart = JSON.parse(sessionStorage.getItem('cart'));
    console.log(this.cart)
    this.value =this.calcValue();
  }
  removeItem(id): void {
    this.cart.splice(id,1);
    this.update();
  }
  update(): void{
    for(let [i,item] of this.cart.entries()){
      if(item.qty<=0) this.cart.splice(i,1);
    }
    sessionStorage.setItem('cart',JSON.stringify(this.cart));
    this.value =this.calcValue();
  }
  calcValue(){
    let sum=0;
    if(this.cart.length>0)for(let item of this.cart){
      sum+=item.price* item.qty;
    }
    return sum
  }

  continue(){
    if(JSON.parse(sessionStorage.getItem('token')).logged ){
      console.log(JSON.parse(sessionStorage.getItem('token')));
      this.router.navigate(["address"]);
    }else this.router.navigate(["login"]);
  }

}
