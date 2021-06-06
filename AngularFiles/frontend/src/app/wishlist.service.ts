import { ToastrService } from 'ngx-toastr';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class WishlistService {

  constructor(private http: HttpClient, private toastr : ToastrService) { }

  getWishList(user) {
    return this.http.get(`https://puertolego-backend.herokuapp.com/wishlist/${user.id}?authKey=${user.token}`, {observe : 'response',responseType: 'json'});
  }

  postWishList(user,id) {
    return this.http.post(`https://puertolego-backend.herokuapp.com/wishlist?authKey=${user.token}&id_client=${user.id}&id_pro=${id}`,id, {observe : 'response',responseType: 'text'}).pipe(
      catchError((err) => {
        this.toastr.error("Błąd operacji");
        return throwError(err);
      }));
  }
  deleteWishList(user,id) {
    return this.http.delete(`https://puertolego-backend.herokuapp.com/wishlist?authKey=${user.token}&id_client=${user.id}&id_wish=${id}`, {observe : 'response',responseType: 'text'}).pipe(
      catchError((err) => {
        this.toastr.error("Błąd operacji");
        return throwError(err);
      }));
  }

}
