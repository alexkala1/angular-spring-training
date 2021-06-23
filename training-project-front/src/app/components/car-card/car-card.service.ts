import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Car } from 'src/app/interface/car';

@Injectable({
  providedIn: 'root'
})
export class CarCardService {
	private message = new BehaviorSubject<string>('asdasdasd');
	currentMessage = this.message.asObservable()

  constructor() { }

	sendSubject(message: string) {
		this.message.next(message)
	}
}
