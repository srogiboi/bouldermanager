import { Injectable } from '@angular/core';
import { Http,Response } from '@angular/http';
import 'rxjs/add/operator/map';

@Injectable()

export class GetService {


    constructor ( private http: Http){
        console.log('Here we go');
    }


    getAllBoulders() {
        return this.http.get('http://localhost:8080/bouldermanager/webapi/boulderlist/').map((res: Response) => res.json());
    }
} 


