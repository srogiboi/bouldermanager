import { Component, OnInit } from '@angular/core';
import { ExampleService } from '../services/example.service';
import { GetService } from '../services/get.service';


@Component({
  selector: 'app-boulders',
  templateUrl: './boulders.component.html',
  styleUrls: ['./boulders.component.scss'],
  providers: [GetService],

})

export class BouldersComponent implements OnInit {

  public boulders: Boulder[];
  public queryAuthor: string = '';
  public queryGrade: string = '';
  public querySector: string = '';

  constructor(private _getService: GetService) {
    this._getService.getAllBoulders().subscribe(data => {
      this.boulders = data;

    });
  }

  ngOnInit() {

  }

  search(queryAuthor: string, queryGrade: string, querySector: string) {
    console.log(queryAuthor, queryGrade, querySector);

    this._getService.getBouldersFromSearch(queryAuthor, queryGrade, querySector).subscribe(data => {
      this.boulders = data;

    });
  }
  clearAll() {
    this.queryAuthor = '';
    this.queryGrade = '';
    this.querySector = '';
    this._getService.getAllBoulders().subscribe(data => {
      this.boulders = data;
    });

  }
  clearSearch(toClear: string) {
    if (toClear == 'author') {
      this.queryAuthor = '';
    } else if (toClear == 'grade') {
      this.queryGrade = '';
    } else if (toClear == 'sector') {
      this.querySector = '';
    }
  }

  sort(query: string) {
    if (query == 'id')
      this.sortID();
    else if (query == "author_name")
      this.sortAuthorName();
    else if (query == "author_last_name")
      this.sortAuthorLastName();
    else if (query == "grade")
      this.sortGrade();
    else if (query == "sector_name")
      this.sortSector();
  }

  public sortID() {
    this.boulders.sort(function (boulder1, boulder2) {
      if (boulder1.id < boulder2.id) {
        return -1;
      } else if (boulder1.id > boulder2.id) {
        return 1;
      } else {
        return 0;
      }
    });
  }

  public sortAuthorName() {
    this.boulders.sort(function (boulder1, boulder2) {
      if (boulder1.authorFirstName < boulder2.authorFirstName) {
        return -1;
      } else if (boulder1.authorFirstName > boulder2.authorFirstName) {
        return 1;
      } else {
        return 0;
      }
    });
  }
  public sortAuthorLastName() {
    this.boulders.sort(function (boulder1, boulder2) {
      if (boulder1.authorLastName < boulder2.authorLastName) {
        return -1;
      } else if (boulder1.authorLastName > boulder2.authorLastName) {
        return 1;
      } else {
        return 0;
      }
    });
  }
  public sortGrade() {
    this.boulders.sort(function (boulder1, boulder2) {
      if (boulder1.grade < boulder2.grade) {
        return -1;
      } else if (boulder1.grade > boulder2.grade) {
        return 1;
      } else {
        return 0;
      }
    });
  }
  public sortSector() {
    this.boulders.sort(function (boulder1, boulder2) {
      if (boulder1.sectorName < boulder2.sectorName) {
        return -1;
      } else if (boulder1.sectorName > boulder2.sectorName) {
        return 1;
      } else {
        return 0;
      }
    });
  }
}
interface Boulder {
  id: number;
  authorId: number;
  authorFirstName: string;
  authorLastName: string;
  grade: string;
  sectorId: number;
  sectorName: string;
  description: string;


}