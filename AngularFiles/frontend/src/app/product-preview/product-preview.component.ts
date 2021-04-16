import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-preview',
  templateUrl: './product-preview.component.html',
  styleUrls: ['./product-preview.component.scss']
})
export class ProductPreviewComponent implements OnInit {
  id: String = "sup";
  title: String = "normalnie fajne lego creeper";
  price: number = 199.90;
  constructor() { }

  ngOnInit(): void {
  }

}
