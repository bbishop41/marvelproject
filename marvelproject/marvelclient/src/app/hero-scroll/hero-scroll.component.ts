import { Component, OnInit } from '@angular/core';
import {HeroService} from '../services/hero.service';


@Component({
  selector: 'app-hero-scroll',
  templateUrl: './hero-scroll.component.html',
  styleUrls: ['./hero-scroll.component.css']
})
export class HeroScrollComponent implements OnInit {
  heroes: Array<any>;

  constructor(private heroService: HeroService) { }
  ngOnInit() {
    this.heroService.getAll().subscribe(data => {
      this.heroes = data;
    });
  }
}
