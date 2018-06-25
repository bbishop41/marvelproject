import { NgModule } from '@angular/core';
import { RouterModule, Routes } from "@angular/router";
import { HeroInfoComponent } from '../hero-info/hero-info.component';
import { HeroScrollComponent } from '../hero-scroll/hero-scroll.component';

const routes: Routes = [
  { path: 'hero-scroll', component: HeroScrollComponent},
  { path: 'hero/:id', component: HeroInfoComponent },
  { path: '', redirectTo: '/hero-scroll', pathMatch: 'full'}
];

@NgModule({
  imports: [ RouterModule.forRoot(routes, { enableTracing: true }) ],
  exports: [ RouterModule ]
})
export class AppRoutesModule { }
