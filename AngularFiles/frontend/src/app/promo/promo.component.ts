import { Component, OnInit } from '@angular/core';
import { ProductService } from './../product.service';

@Component({
  selector: 'app-promo',
  templateUrl: './promo.component.html',
  styleUrls: ['./promo.component.scss']
})
export class PromoComponent implements OnInit {
  data:any[]

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.productService.getProductforPromo().subscribe((data: any[])=>{
      this.data = data;
    });

  }

}
