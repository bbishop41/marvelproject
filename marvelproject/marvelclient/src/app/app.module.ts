import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeroScrollComponent } from './hero-scroll/hero-scroll.component';
import { HttpClientModule } from '@angular/common/http';
import { HeroService } from './services/hero.service';

@NgModule({
  declarations: [
    AppComponent,
    HeroScrollComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [HeroService],
  bootstrap: [AppComponent]
})
export class AppModule { }
