import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegionListComponent } from './region-list/region-list.component';
import { CountryListComponent } from './country-list/country-list.component';

const routes: Routes = [
  { path: '', redirectTo: '/regions', pathMatch: 'full' },
  { path: 'regions', component: RegionListComponent },
  { path: 'countries', component: CountryListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }