import { Component, signal } from '@angular/core';
import { Footer } from "./Components/footer/footer";
import { Header } from "./Components/header/header";
import { Sidebar } from "./Components/sidebar/sidebar";
import { RouterOutlet } from "@angular/router";

@Component({
  selector: 'app-root',
  imports: [Footer, Header, Sidebar, RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('frontend');
  sidebarOpen = true;

  toggleSidebar(): void {
    this.sidebarOpen = !this.sidebarOpen;
  }
}
