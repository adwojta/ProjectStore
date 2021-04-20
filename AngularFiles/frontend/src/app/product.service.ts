import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) {
   }

   getProductforAnnouncements() {
    return this.http.get('http://localhost:8080/product/collection/Marvel');

   }
  getProductforPromo() {
    return this.http.get('http://localhost:8080/product/promoted/');
  }

   getProduct(id) {
    return this.http.get('http://localhost:8080/product/' + id);
  }

  getSeries() {
    return this.http.get('http://localhost:8080/product/collections/');
  }

  getSpecificSeries(serie) {
    return this.http.get('http://localhost:8080/product/collection/' + serie);
  }
}
