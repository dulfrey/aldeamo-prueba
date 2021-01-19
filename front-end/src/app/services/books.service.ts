import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class BooksService {
  private booksData: BehaviorSubject<any> = new BehaviorSubject([]);
  public booksData$ = this.booksData.asObservable();
  books
  constructor(private http: HttpClient) { }
  getBooks(){
    return this.http.get('http://199.192.21.9:8080/demo-0.0.1-SNAPSHOT/books', {headers :{'Access-Control-Allow-Origin': '*'}}).subscribe(data => {
      this.booksData.next(data);
      return data;
    });
  }
  
  sellBook(id,quantity,index){
    let book = {
      id,
      quantity
    }
    return this.http.post('http://199.192.21.9:8080/demo-0.0.1-SNAPSHOT/books/buy',book).subscribe(data => {
      let car = localStorage.getItem('cart');
      let cart = JSON.parse(car)
      alert(data['message'])
      cart.splice(index,1)
      localStorage.setItem('cart',car)
      console.log(data['message'])
      
      return data;
    });
  }
}
