import { Routes } from '@angular/router';
import { Dashboard } from './Pages/dashboard/dashboard';
import { Pds } from './Pages/PDS/pds';

export const routes: Routes = [
  { path: '', component: Dashboard },
  { path: 'pds', component: Pds },
  { path: '**', redirectTo: '' }
];
