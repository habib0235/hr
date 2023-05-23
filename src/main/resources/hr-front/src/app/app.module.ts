import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { RegionListComponent } from './region-list/region-list.component';
import { HttpClientModule } from '@angular/common/http';
import { RegionDetailsComponent } from './region-details/region-details.component';

@NgModule({
  declarations: [
    AppComponent,
    RegionListComponent,
    RegionDetailsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
