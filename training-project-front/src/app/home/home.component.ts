import {
  Component,
  OnInit,
  QueryList,
  ViewChild,
  ViewChildren,
} from '@angular/core';
import { CarCardComponent } from '../components/car-card/car-card.component';
import { Car } from '../interface/car';
import { HomeService } from './home.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss'],
})
export class HomeComponent implements OnInit {
  cars: any;
  discountCodeApplied: boolean = false;

  @ViewChild(CarCardComponent) child!: CarCardComponent;
  @ViewChildren(CarCardComponent) children!: QueryList<CarCardComponent>;

  constructor(private homeService: HomeService) {}

  ngOnInit(): void {
    this.cars = [];
    this.homeService
      .getAllCars()
      .subscribe((response) => (this.cars = response), console.error);
  }

  addToCart(car: Car) {
    this.child?.addToCart(car);
  }

  applyDiscountCode(): void {
    this.children.toArray().forEach((child) => {
			if (child.car.mileage && !this.discountCodeApplied)
				child.car.mileage /= 2
		});

		this.discountCodeApplied = true
  }

	onSelectedCar(car: Car): void {
		console.log(car)
	}
}
