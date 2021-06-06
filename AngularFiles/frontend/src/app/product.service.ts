import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private messageSource = new BehaviorSubject({});
  currentMessage = this.messageSource.asObservable();

  constructor(private http: HttpClient, private toastr: ToastrService) {}

  changeMessage(message: any) {
    this.messageSource.next(message)
  }
  getOrders(user){
    return this.http.get(`https://puertolego-backend.herokuapp.com/Transaction/${user.id}?authKey=${user.token}`,{observe : 'response',responseType: 'json'}).pipe(
      catchError(() => {
        this.toastr.error("Nie można wczytać historii tranzakcji!","Niepowodzenie!");
        return throwError("err");
      }))
  }
  makeOrder(user,items){
    return this.http.post(`https://puertolego-backend.herokuapp.com/Transaction/${user.client}?authKey=${user.token}&city=${user.city}&country=${user.country}&paymentMethod=${user.paymentMethod}&postcode=${user.postcode}&price=${user.price}&street=${user.street}`,items,{observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        this.toastr.error("Brak tylu sztuk w magazynie! Sprawdź dostępność na stronie produktu!","Niepowodzenie!");
        return throwError("err");
      }))
  }

  getProductforAnnouncements() {
    return this.http.get('https://puertolego-backend.herokuapp.com/product/collection/Marvel');

   }
  getProductforPromo() {
    return this.http.get('https://puertolego-backend.herokuapp.com/product/promoted/');
  }

  getProduct(id) {
    return this.http.get('https://puertolego-backend.herokuapp.com/product/' + id);
  }

  getSeries() {
    return this.http.get('https://puertolego-backend.herokuapp.com/product/collections/');
  }

  getSpecificSeries(serie) {
    return this.http.get('https://puertolego-backend.herokuapp.com/product/collection/' + serie);
  }

  getProductComments(id) {
    return this.http.get('https://puertolego-backend.herokuapp.com/comment/' + id);
  }
  postComment(comment) {
    return this.http.post(`https://puertolego-backend.herokuapp.com/comment/${comment.id}?authKey=${comment.auth}&description=${comment.desc}&id_client=${comment.client}&rating=${comment.rating}`,comment,{observe : 'response',responseType: 'text'});
  }

}
