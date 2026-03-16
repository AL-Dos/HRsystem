import { Component, signal } from '@angular/core';
import { Footer } from "./Components/footer/footer";
import { Header } from "./Components/header/header";
import { Router, RouterOutlet } from "@angular/router";
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, CommonModule, Header, Footer],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
  constructor(public router: Router) {}
}
