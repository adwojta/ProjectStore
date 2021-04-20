import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import {Product} from './../Product.model';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {
  id: number;
  product: Product;
  constructor(private route: ActivatedRoute, private productService: ProductService) {

   }

  ngOnInit(): void {

    this.route.queryParams.subscribe(params => {
      this.id = params['id'];
      this.productService.getProduct(this.id).subscribe((data: Product)=>{
        this.product = data;
      });
    });


  }

}
