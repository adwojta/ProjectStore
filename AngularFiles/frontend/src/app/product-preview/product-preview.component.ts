import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-product-preview',
  templateUrl: './product-preview.component.html',
  styleUrls: ['./product-preview.component.scss']
})
export class ProductPreviewComponent implements OnInit {

  @Input() id: number;
  @Input() title: String;
  @Input() price: number;
  constructor() { }

  ngOnInit(): void {
  }

}
