import { HttpClient, provideHttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient){}

  url = "http://localhost:8081/api/v1/user";

  fetchUsers(){
    return this.http.get(this.url);
  }

  deleteUser(id:number){
    console.log(id)
    return this.http.delete(this.url + "/" + id,{
      responseType: 'text'
    });
  }

  postUser(body:any){
    return this.http.post(this.url,body);
  }
  updateUser(body:any){
    return this.http.patch(this.url + "/" + body.id,body);
  }
}

