import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {DashboardComponent} from './dashboard/dashboard.component';
import {ResultsComponent} from './results/results.component'

const routes: Routes = [
  {path: '', component: DashboardComponent},
  {path: 'playlist/:name', component: ResultsComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes,{ enableTracing: true })],
  exports: [RouterModule]
})
export class AppRoutingModule {}
