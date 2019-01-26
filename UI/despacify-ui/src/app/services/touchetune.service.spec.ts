import { TestBed } from '@angular/core/testing';

import { TouchetuneService } from './touchetune.service';

describe('TouchetuneService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: TouchetuneService = TestBed.get(TouchetuneService);
    expect(service).toBeTruthy();
  });
});
