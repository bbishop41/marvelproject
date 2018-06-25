import {Component, Input, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {Hero} from '../models/hero';

@Component({
  selector: 'app-hero-info',
  templateUrl: './hero-info.component.html',
  styleUrls: ['./hero-info.component.css']
})
export class HeroInfoComponent implements OnInit {
  @Input() hero: Hero;

  constructor(
    private route: ActivatedRoute
  ) { }

  ngOnInit() {
  }

}
