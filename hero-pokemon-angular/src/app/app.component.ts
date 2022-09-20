import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  titulo: string;

  title = 'hero-pokemon-angular';

  constructor() {
    this.titulo = "Hero Pokémon - Angular"
  }
}
