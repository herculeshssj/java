import { Component, OnInit } from '@angular/core';
import { Trainer } from '../trainer';
import { TrainerService } from '../trainer-service.service';

@Component({
  selector: 'app-trainer-list',
  templateUrl: './trainer-list.component.html',
  styleUrls: ['./trainer-list.component.css']
})
export class TrainerListComponent implements OnInit {

  trainers: Trainer[];

  constructor(private trainerService: TrainerService) {
  }

  ngOnInit() {
    this.trainerService.findAll().subscribe(data => {
      this.trainers = data;
    });
  }

}
