import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routes } from './app.router';
 
import { AppComponent } from './app.component';
import { AboutComponent } from './about/about.component';
import { BouldersComponent } from './boulders/boulders.component';
import { AscentsComponent } from './ascents/ascents.component';
import { SearchComponent } from './search/search.component';
import { ManageComponent } from './manage/manage.component';
import { MainComponent } from './main/main.component';
import { FooterComponent } from './footer/footer.component';
import { HorizontalLogoComponent } from './horizontal-logo/horizontal-logo.component';

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    AboutComponent,
    BouldersComponent,
    AscentsComponent,
    SearchComponent,
    ManageComponent,
    FooterComponent,
    HorizontalLogoComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routes
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
