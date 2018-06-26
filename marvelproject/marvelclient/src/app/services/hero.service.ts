import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { Hero } from '../models/hero';
import { HEROES } from '../models/mock-heroes';

@Injectable()
export class HeroService {
  public HERO_API = '//localhost:8080/characters';

  constructor(private http: HttpClient) {
  }

  getHeroes(): Observable<Hero[]> {
    return of(HEROES);
  }

  getHero(id: number): Observable<any> {
    return this.http.get(this.HERO_API + '/' + id)
  }
}
