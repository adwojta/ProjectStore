import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ProductService } from '../product.service';

@Component({
  selector: 'app-serie',
  templateUrl: './serie.component.html',
  styleUrls: ['./serie.component.scss']
})
export class SerieComponent implements OnInit {
  @Input() title: String;
  data: any[];
  constructor(private route: ActivatedRoute, private productService: ProductService) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( params =>{
      this.title = params.get('title');
      this.productService.getSpecificSeries(this.title).subscribe((data: any[])=>{
        this.data = data;
      });
    });

  }

}
