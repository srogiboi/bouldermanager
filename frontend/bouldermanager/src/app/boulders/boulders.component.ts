import { Component, OnInit } from '@angular/core';
import { ExampleService } from '../services/example.service';
import { GetService } from '../services/get.service';


@Component({
  selector: 'app-boulders',
  templateUrl: './boulders.component.html',
  styleUrls: ['./boulders.component.scss'],
  providers: [GetService]
})

export class BouldersComponent implements OnInit {

  public boulders: Boulder[];

  constructor(private _getService: GetService) {
    this._getService.getAllBoulders().subscribe(data => {
      this.boulders = data;

    });
  }

  ngOnInit() {

  }

}
interface Boulder {
  authorId: number;
  description: string;
  grade: string;
  id: number;
  sectorId: number;
}
