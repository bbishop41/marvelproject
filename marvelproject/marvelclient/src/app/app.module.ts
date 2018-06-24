import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeroScrollComponent } from './hero-scroll/hero-scroll.component';
import { HttpClientModule } from '@angular/common/http';
import { HeroService } from './services/hero.service';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatCardModule } from "@angular/material";
import { MatToolbarModule } from "@angular/material";

@NgModule({
  declarations: [
    AppComponent,
    HeroScrollComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatCardModule,
    MatToolbarModule
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
