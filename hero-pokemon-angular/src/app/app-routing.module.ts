import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrainerListComponent } from './trainer-list/trainer-list.component';
import { TrainerFormComponent } from './trainer-form/trainer-form.component';


const routes: Routes = [
  { path: 'trainers', component: TrainerListComponent },
  { path: 'addtrainer', component: TrainerFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
