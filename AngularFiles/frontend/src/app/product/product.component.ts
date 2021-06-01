import { WishlistService } from './../wishlist.service';
import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Product} from './../Product.model';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  id: number;
  qty: number = 1;
  product: Product ={
    "age": '',
    "collection": '',
    "elements": 0,
    "id_pro": 0,
    "name": '',
    "price": 0,
    "quantity": 0};
  comments : any;
  newComment: any = {
    description: "",
    rating: null
  };
  token: any;
  wishes=[];
  butn;
  constructor(private route: ActivatedRoute, private productService: ProductService, private toastr: ToastrService, private wishlist: WishlistService) {}
  addComment(): void{
    let token = JSON.parse(sessionStorage.getItem('token'));
    if(this.newComment.rating > 5) this.newComment.rating = 5;
    else if(this.newComment.rating < 1) this.newComment.rating = 1;
    this.productService.postComment({id: this.id, auth: token.token, desc: this.newComment.description, client: token.id,rating: this.newComment.rating}).subscribe( data =>{
      this.getComments(this.id);
      if(data.status == 201) this.toastr.success("Dodano Komentarz!","Sukces!");
    });

  }

  updateWishlist(){
      if(this.searchWishes(this.product.id_pro)){
        let t = this.wishes.findIndex(e => e.id_pro == this.product.id_pro)
        this.wishlist.deleteWishList(this.token,this.wishes[t].id_wish).subscribe( data =>{
          if(data.status == 200){
            this.toastr.success("Usunięto produkt z Listy Życzeń!","Sukces!");
          }
          this.getWishlist();
        });
      }else this.wishlist.postWishList(this.token,this.product.id_pro).subscribe( data =>{
        if(data.status == 201){
          this.toastr.success("Dodano produkt do Listy Życzeń!","Sukces!");
        }
        this.getWishlist();
      });

}
  searchWishes(id){
    return this.wishes.some(e => e.id_pro === id)
  }

  addItem():void {
    if(this.product.id_pro != 0 && this.qty>0) {
      let cart = JSON.parse(sessionStorage.getItem('cart'))
      if(!cart.some(e => e.id === this.product.id_pro)){
        if(this.qty > this.product.quantity) this.qty = this.product.quantity;
        cart.push({id: this.product.id_pro, name: this.product.name, price: this.product.price, qty: this.qty});
        this.toastr.success("Produkt został dodany do koszyka!","Sukces!")
        }else this.toastr.error("Produkt już jest w koszyku!","Niepowodzenie!")
      sessionStorage.setItem('cart',JSON.stringify(cart));
      }else this.toastr.error("Niepoprawna ilość!","Niepowodzenie!")
  }

  getComments(id){
    this.productService.getProductComments(id).subscribe( data =>{
      this.comments = data;
  });
  }

  getWishlist(){
    this.wishlist.getWishList(this.token).subscribe(data =>{
      this.wishes = Array.from(Object.values(data.body));
      this.butn = this.searchWishes(this.product.id_pro);
    });
  }

  ngOnInit(): void {
    this.token = JSON.parse(sessionStorage.getItem('token'));
    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
      this.productService.getProduct(this.id).subscribe((data: Product)=>{
        this.product = data;
        this.getComments(this.id);
      });
    });
    this.getWishlist();
  }

}
