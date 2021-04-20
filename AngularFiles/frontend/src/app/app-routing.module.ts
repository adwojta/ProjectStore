import { SeriesComponent } from './series/series.component';
import { PromoComponent } from './promo/promo.component';
import { ProfileComponent } from './profile/profile.component';
import { ProductComponent } from './product/product.component';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { BasketComponent } from './basket/basket.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { ContactComponent } from './contact/contact.component';

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { SerieComponent } from './serie/serie.component';

const routes: Routes = [
  { path: 'announcements', component: AnnouncementsComponent },
  { path: 'basket', component: BasketComponent },
  { path: 'checkout', component: CheckoutComponent },
  { path: 'contact', component: ContactComponent },
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'product', component: ProductComponent },
  { path: 'announcements/product', component: ProductComponent },
  { path: 'profile', component: ProfileComponent },
  { path: 'promo', component: PromoComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'series', component: SeriesComponent },
  { path: 'series/serie', component: SerieComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
