import { ToastrService } from 'ngx-toastr';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, Subject, throwError } from 'rxjs';
import {  catchError } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private loginSource = new Subject<boolean>();

  constructor(private http: HttpClient,private toastr:ToastrService) { }

  public checkLogin(): Observable<boolean> {
    return this.loginSource.asObservable();
  }
  public setLogin(state: boolean) {
    return this.loginSource.next(state);
  }
  getAddress(user) {
    return this.http.get('http://localhost:8080/adress/'+ user.id +'?authKey='+ user.token, {observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        this.toastr.error("Nie udało się zmienić danych. Spróbuj ponownie!","Niepowodzenie!");
        return throwError("err");
      }))
  }
  setAddress(user) {
    return this.http.post(`http://localhost:8080/adress?authKey=${user.token}&city=${user.city}&country=${user.country}&id_client=${user.client}&postcode=${user.postcode}&street=${user.street}`,user, {observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        this.toastr.error("Nie udało się zmienić danych. Spróbuj ponownie!","Niepowodzenie!");
        return throwError("err");
      }))
  }
  changeAddress(user) {
    return this.http.put(`http://localhost:8080/adress?authKey=${user.token}&city=${user.city}&country=${user.country}&id_adr=${user.idadr}&id_client=${user.client}&postcode=${user.postcode}&street=${user.street}`,user, {observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        return throwError("err");
      }))
  }

  createUser(user){
    return this.http.post(`http://localhost:8080/Client/Register?name=${user.name}&password=${user.password}&surname=${user.surname}&username=${user.username}`,user, {observe : 'response',responseType: 'text'}).pipe(
      catchError((err) => {
        this.toastr.error(" ","Błąd rejestracji!");
        return throwError(err);
      }))
  }
  changeInfo(user) {
    return this.http.put('http://localhost:8080/Client/'+ user.id +'/changeInfo?authKey='+ user.token + '&name='+ user.name + '&surname='+ user.surname, user, {observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        this.toastr.error("Nie udało się zmienić danych. Spróbuj ponownie!","Niepowodzenie!");
        return throwError("err");
      }))
  }
  changePass(user) {
    return this.http.put('http://localhost:8080/Client/'+ user.id +'?authKey='+ user.token + '&newPw='+ user.new + '&oldPw='+ user.old, user, {observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        this.toastr.error("Nie udało się zmienić hasła. Spróbuj ponownie!","Niepowodzenie!");
        return throwError("err");
      }))
  }
  getInfo(user) {
    return this.http.get('http://localhost:8080/Client/'+ user.id +'?authKey='+ user.token, {observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        return throwError("err");
      }))
  }
  getLogin(user) {
    return this.http.get('http://localhost:8080/Client/login?password=' + user.password + '&username='+ user.username, {observe : 'response',responseType: 'text'}).pipe(
      catchError(() => {
        this.toastr.error("Niepoprawne dane logowania!","Niepowodzenie!");
        return throwError("err");
      }))
  }

}
