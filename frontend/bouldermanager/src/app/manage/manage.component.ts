import { Component, OnInit } from '@angular/core';
import { ChartsModule, Color } from 'ng2-charts';

@Component({
  selector: 'app-manage',
  templateUrl: './manage.component.html',
  styleUrls: ['./manage.component.scss']
})
export class ManageComponent implements OnInit {
  name: string;
  labels: string[] = ['red', 'blue', 'yellow', 'black'];
  data: number[] = [350, 450, 100, 200];
  type: string = 'doughnut';

  colorsUndefined: Array<Color>;
  colorsEmpty: Array<Color> = [];
  colorsOverride: Array<Color> = [{
    backgroundColor: 'green',
    hoverBackgroundColor: 'purple'
  }];
  colorsEmptyObject: Array<Color> = [{}];

  datasets: any[] = [
    {
      data: this.data,
    }];

  constructor() {
  }

  ngOnInit() {
  }

}
