import { Injectable } from '@angular/core';
import { Observable, Subject } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CommunicationService {
  private topics = new Map<string, Subject<any>>();

  constructor() {}

  getSubject(name: string): Subject<any> {
		let topic = this.topics.get(name)

		if (topic == null) {
			topic = new Subject<any>()
			this.topics.set(name, topic)
		}

		return topic
  }

  getTopic(name: string) {
    return this.getSubject(name).asObservable();
  }

  send(name: string, message: any) {
    let topic = this.getSubject(name);

		topic.next(message)
  }
}
