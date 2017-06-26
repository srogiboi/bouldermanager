import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { RequestOptions } from '@angular/http';
import { URLSearchParams } from '@angular/http';

import 'rxjs/add/operator/map';

@Injectable()

export class GetService {


    constructor(private http: Http) {
        console.log('Here we go');
    }


    getAllBoulders() {
        return this.http.get('http://localhost:8080/bouldermanager/webapi/boulderlist/').map((res: Response) => res.json());
    }
    getBouldersFromSearch(author: string, grade: string, sector: string) {
        let params: URLSearchParams = new URLSearchParams();
        params.set('author', author);
        params.set('grade', grade);
        params.set('sector', sector);

        let requestOptions = new RequestOptions();
        requestOptions.search = params;

        return this.http.get('http://localhost:8080/bouldermanager/webapi/boulderlist/query', requestOptions).map((res: Response) => res.json());
    }
}


