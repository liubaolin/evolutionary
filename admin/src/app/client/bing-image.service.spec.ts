import { TestBed, inject } from '@angular/core/testing';

import { BingImageService } from './bing-image.service';

describe('BingImageService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [BingImageService]
    });
  });

  it('should ...', inject([BingImageService], (service: BingImageService) => {
    expect(service).toBeTruthy();
  }));
});
