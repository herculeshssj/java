import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Trainer } from '../trainer';
import { TrainerService } from '../trainer-service.service';

@Component({
  selector: 'app-trainer-form',
  templateUrl: './trainer-form.component.html',
  styleUrls: ['./trainer-form.component.css']
})
export class TrainerFormComponent implements OnInit {

  trainer: Trainer;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private trainerService: TrainerService) {
    this.trainer = new Trainer();
  }

  onSubmit() {
    this.trainerService.save(this.trainer).subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/trainers']);
  }

  ngOnInit(): void {
  }

}
