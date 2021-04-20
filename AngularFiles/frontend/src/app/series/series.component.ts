import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-series',
  templateUrl: './series.component.html',
  styleUrls: ['./series.component.scss']
})
export class SeriesComponent implements OnInit {
  data: any[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {

    this.productService.getSeries().subscribe((data: any[])=>{
      this.data = data;
    });
  }

}
