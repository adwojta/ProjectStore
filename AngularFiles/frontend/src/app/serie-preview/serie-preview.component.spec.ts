import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SeriePreviewComponent } from './serie-preview.component';

describe('SeriePreviewComponent', () => {
  let component: SeriePreviewComponent;
  let fixture: ComponentFixture<SeriePreviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SeriePreviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SeriePreviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
