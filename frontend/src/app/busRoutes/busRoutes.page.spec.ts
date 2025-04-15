import { ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { ExploreContainerComponentModule } from '../explore-container/explore-container.module';

import { BusRoutesPage } from './busRoutes.page';

describe('Tab1Page', () => {
  let component: BusRoutesPage;
  let fixture: ComponentFixture<BusRoutesPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BusRoutesPage],
      imports: [IonicModule.forRoot(), ExploreContainerComponentModule]
    }).compileComponents();

    fixture = TestBed.createComponent(BusRoutesPage);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
