import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RegionListComponent } from './region-list/region-list.component';
import { HttpClientModule } from '@angular/common/http';
import { RegionDetailsComponent } from './region-details/region-details.component';
import { CountryListComponent } from './country-list/country-list.component';
import { CountryDetailsComponent } from './country-details/country-details.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import {MatGridListModule} from '@angular/material/grid-list';
import { provideAnimations } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';

@NgModule({
  declarations: [
    AppComponent,
    RegionListComponent,
    RegionDetailsComponent,
    CountryListComponent,
    CountryDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatGridListModule,
    AppRoutingModule
  ],
  providers: [provideAnimations()],
  bootstrap: [AppComponent]
})
export class AppModule { }
