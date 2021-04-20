import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

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
    return this.http.get('http://localhost:8080/product/promoted%27');
  }

   getProduct(id) {
    return this.http.get('http://localhost:8080/product/' + id);
  }

  getSeries() {
    return this.http.get('http://localhost:8080/product/collections%27');
  }

  getSpecificSeries(serie) {
    return this.http.get('http://localhost:8080/product/collections/%27' + serie);
  }
}
