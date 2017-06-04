import { ModuleWithProviders } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { MainComponent } from './main/main.component';
import { AboutComponent } from './about/about.component';
import { AscentsComponent } from './ascents/ascents.component';
import { BouldersComponent } from './boulders/boulders.component';
import { ManageComponent } from './manage/manage.component';
import { SearchComponent } from './search/search.component';

export const router: Routes = [
    { path: '', redirectTo: 'main', pathMatch: 'full' },
    { path: 'main', component: MainComponent },
    { path: 'about', component: AboutComponent },
    { path: 'ascents', component: AscentsComponent },
    { path: 'boulders', component: BouldersComponent },
    { path: 'manage', component: ManageComponent },
    { path: 'search', component: SearchComponent } 

];

export const routes: ModuleWithProviders = RouterModule.forRoot(router);