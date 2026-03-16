import { Routes } from '@angular/router';
import { Dashboard } from './Pages/dashboard/dashboard';

export const routes: Routes = [
  { path: '', component: Dashboard },
  { path: '**', redirectTo: '' }
];
