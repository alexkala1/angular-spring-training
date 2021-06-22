import { Component, OnInit } from '@angular/core';
import { Car } from '../interface/car';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  cars: any;
  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
		this.cars = []
    this.homeService
      .getAllCars()
      .subscribe((response) => (this.cars = response), console.error);
  }
}
