import { isPlatformBrowser } from '@angular/common';
import { Component, OnInit, PLATFORM_ID, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { RouterLink } from '@angular/router';
import { catchError, of } from 'rxjs';

interface Person {
  id: number;
  photoUrl?: string | null;
  referenceNumber?: string | null;
  signature?: string | null;
  type?: string | null;
  position?: string | null;
  status?: {
    id: number;
    option: string;
  } | null;
  name?: string | null;
}

@Component({
  selector: 'app-dashboard',
  imports: [CommonModule, RouterLink],
  templateUrl: './dashboard.html',
  styleUrl: './dashboard.css',
})
export class Dashboard implements OnInit {
  private http = inject(HttpClient);
  private platformId = inject(PLATFORM_ID);

  loading = true;
  errorMessage = '';
  people: Person[] = [];

  ngOnInit(): void {
    if (!isPlatformBrowser(this.platformId)) {
      this.loading = false;
      return;
    }

    this.http.get<Person[]>('/api/persons')
      .pipe(
        catchError(() => {
          this.errorMessage = 'Unable to load employees. Please try again later.';
          this.loading = false;
          return of([]);
        })
      )
      .subscribe((people) => {
        this.people = people ?? [];
        this.loading = false;
      });
  }

  getInitials(name?: string | null): string {
    if (!name) return '—';
    const parts = name.trim().split(/\s+/).filter(Boolean);
    if (parts.length === 0) return '—';
    const first = parts[0]?.[0] ?? '';
    const last = parts.length > 1 ? parts[parts.length - 1]?.[0] ?? '' : '';
    return `${first}${last}`.toUpperCase();
  }
}
