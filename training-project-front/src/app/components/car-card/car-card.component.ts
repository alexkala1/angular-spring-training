import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Car } from 'src/app/interface/car';

@Component({
  selector: 'app-car-card',
  templateUrl: './car-card.component.html',
  styleUrls: ['./car-card.component.scss'],
})
export class CarCardComponent implements OnInit {
  @Input() car!: Car;
	@Output() selectedCar = new EventEmitter<Car>()

  constructor() {}

  ngOnInit(): void {}

  addToCart(car: Car): string {
    return `${car.brand} ${car.model} was added to cart`;
  }

	onSelected() {
		this.selectedCar.emit(this.car)
	}
}
