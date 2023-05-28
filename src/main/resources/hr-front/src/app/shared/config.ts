import { HttpHeaders } from '@angular/common/http';

export class Config {
    static httpOptions = {
        headers: new HttpHeaders({
            'Content-Type': 'application/json'
        })
    };
}