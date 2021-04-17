import { ProductService } from './../product.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-announcements',
  templateUrl: './announcements.component.html',
  styleUrls: ['./announcements.component.scss']
})
export class AnnouncementsComponent implements OnInit {
  data: any[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {

    this.productService.getProductforAnnouncements().subscribe((data: any[])=>{
      this.data = data;
    });

  }


}
