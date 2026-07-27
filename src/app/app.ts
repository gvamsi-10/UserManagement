import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { UserService } from './user-service';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-root',
  imports: [CommonModule,FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})

export class App {

  protected readonly title = signal('CrudOperations');
  users:any[] = [];
  formheader = "Add User";
  username="";
  userage!:Number;
  usercity="";
  userid!:Number;
  displayuserform= false;

  addUser(data:any=null){
    this.displayuserform = true;
    if(data){
      this.formheader = "Edit User";
      this.username = data.name;
      this.usercity = data.city;
      this.userage = data.age;
      this.userid = data.id;
    }
    else{
      this.formheader = "Add User";
      this.userid = 0;
    }
  }

  closeform(){
    this.username = "";
      this.usercity = "";
      this.userage = 0 ;
      this.userid = 0;
      this.formheader = "Add User";
    this.displayuserform = false;
  }
  saveUser(){
    this.displayuserform = false;
    let body:{id?:Number, name:string, age:Number,city:string}={
    name : this.username,
    age : this.userage,
    city : this.usercity
    }

    if(this.userid){
      body.id = this.userid;
      this.userservice.updateUser(body).subscribe((data:any)=>{
        this.getUser();
      },
    (error)=>{
      console.log(error)
    }
    )
    
    }
    else{
      this.userservice.postUser(body).subscribe((data:any)=>{
      this.users.push(data);
      this.getUser();
    },(error)=>{
      console.log(error);
    })
    }
    this.closeform();
  }

  constructor(private userservice:UserService){}

  

  ngOnInit(){
    this.getUser();
  }

  getUser(){
    this.userservice.fetchUsers().subscribe((data:any)=>
    {
      this.users = data;
      console.log(this.users)
    },(error)=>{
      console.log(error);
    })
  }

  deleteUser(id:number){
    console.log("in delete")
    this.userservice.deleteUser(id).subscribe((data)=>{
      alert(data);
      this.getUser();
    },(error)=>{
      console.log(error);
    })
  }

}
