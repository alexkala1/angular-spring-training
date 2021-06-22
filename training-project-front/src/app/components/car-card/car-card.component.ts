import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-car-card',
  templateUrl: './car-card.component.html',
  styleUrls: ['./car-card.component.scss']
})
export class CarCardComponent implements OnInit {

	@Input() brand: string | undefined;
	@Input() model: string | undefined;
	@Input() horsePower: string | undefined;
	@Input() engine: string | undefined;
	@Input() color: string | undefined;
	@Input() mileage: string | undefined;

  constructor() { }

  ngOnInit(): void {
  }

}
