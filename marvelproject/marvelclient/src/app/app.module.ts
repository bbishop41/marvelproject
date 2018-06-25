import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeroScrollComponent } from './hero-scroll/hero-scroll.component';
import { HttpClientModule } from '@angular/common/http';
import { HeroService } from './services/hero.service';
import { MatCardModule } from "@angular/material";
import { MatToolbarModule } from "@angular/material";
import { MatButtonModule } from "@angular/material";
import { AppRoutesModule } from './app-routes/app-routes.module';
import { HeroInfoComponent } from "./hero-info/hero-info.component";

@NgModule({
  declarations: [
    AppComponent,
    HeroScrollComponent,
    HeroInfoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MatCardModule,
    MatToolbarModule,
    AppRoutesModule,
    MatButtonModule
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
