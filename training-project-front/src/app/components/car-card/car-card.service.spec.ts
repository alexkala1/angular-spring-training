import { TestBed } from '@angular/core/testing';

import { CarCardService } from './car-card.service';

describe('CarCardService', () => {
  let service: CarCardService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CarCardService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
