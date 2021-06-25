import { Component, Input, OnInit, Output, EventEmitter } from '@angular/core';
import { Car } from 'src/app/interface/car';
import { CommunicationService } from 'src/app/services/communication.service';

@Component({
  selector: 'app-car-card',
  templateUrl: './car-card.component.html',
  styleUrls: ['./car-card.component.scss'],
})
export class CarCardComponent implements OnInit {
  @Input() car!: Car;
  @Output() selectedCar = new EventEmitter<Car>();

  constructor(private communicationService: CommunicationService) {}

  ngOnInit(): void {}

  addToCart(car: Car): string {
    return `${car.brand} ${car.model} was added to cart`;
  }

  onSelected() {
    this.selectedCar.emit(this.car);
		
    this.communicationService.getTopic('test').subscribe(console.log);
  }
}
