import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Hero } from '../models/hero';
import { HEROES } from '../models/mock-heroes';

@Injectable()
export class HeroService {

  constructor(private http: HttpClient) {
  }

  getHeroes(): Observable<Hero[]> {
    return of(HEROES);
  }
}
