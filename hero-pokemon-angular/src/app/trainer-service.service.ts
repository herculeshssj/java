import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Trainer } from '../app/trainer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TrainerService {

  private trainersUrl: string;

  constructor(private http: HttpClient) {
    this.trainersUrl = 'http://192.168.56.10:8080/trainers';
  }

  public findAll(): Observable<Trainer[]> {
    return this.http.get<Trainer[]>(this.trainersUrl);
  }

  public save(trainer: Trainer) {
    return this.http.post<Trainer>(this.trainersUrl, trainer);
  }
}
