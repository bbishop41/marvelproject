import { Component, OnInit } from '@angular/core';
import { HeroService } from '../services/hero.service';
import { Hero } from '../models/hero';


@Component({
  selector: 'app-hero-scroll',
  templateUrl: './hero-scroll.component.html',
  styleUrls: ['./hero-scroll.component.css']
})
export class HeroScrollComponent implements OnInit {
  heroes: Array<Hero>;

  constructor(private heroService: HeroService) { }
  ngOnInit() {
    this.heroService.getHeroes().subscribe(data => {
      this.heroes = data;
    });
  }
}
