import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContactComponent } from './contact/contact.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ProfileComponent } from './profile/profile.component';
import { CheckoutComponent } from './checkout/checkout.component';
import { ProductComponent } from './product/product.component';
import { BasketComponent } from './basket/basket.component';
import { PromoComponent } from './promo/promo.component';
import { SeriesComponent } from './series/series.component';
import { AnnouncementsComponent } from './announcements/announcements.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { HomeComponent } from './home/home.component';
import { ProductPreviewComponent } from './product-preview/product-preview.component';
import { SerieComponent } from './serie/serie.component';
import { SeriePreviewComponent } from './serie-preview/serie-preview.component';
import { FormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { AddressComponent } from './address/address.component';



@NgModule({
  declarations: [
    AppComponent,
    ContactComponent,
    HeaderComponent,
    FooterComponent,
    ProfileComponent,
    CheckoutComponent,
    ProductComponent,
    BasketComponent,
    PromoComponent,
    SeriesComponent,
    AnnouncementsComponent,
    LoginComponent,
    RegisterComponent,
    HomeComponent,
    ProductPreviewComponent,
    SerieComponent,
    SeriePreviewComponent,
    AddressComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    BrowserAnimationsModule,
    ToastrModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
