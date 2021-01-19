import { Component, OnInit } from '@angular/core';
import { BooksService } from 'src/app/services/books.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.sass']
})
export class ListComponent implements OnInit {
  cart=[];

  constructor(private bookserv: BooksService) { }
  books = [
    {
        "id": 1,
        "name": "Harry 1",
        "price": 30,
        "img": "https://tse1.explicit.bing.net/th?id=OIP.3cACEgHek_R_FuknYTcSswHaJ4&pid=Api",
        "quantity": 10,
        "desc": "First book "
    },
    {
        "id": 2,
        "name": "Harry 1",
        "price": 15,
        "img": "https://kaiserem.files.wordpress.com/2010/10/hp6_poster_2.jpg",
        "quantity": 34,
        "desc": ""
    },
    {
        "id": 4,
        "name": "Harry 3",
        "price": 70,
        "img": "https://mypostercollection.com/wp-content/uploads/2018/09/Harry-Potter-Poster-2004-MyPosterCollection.com-23.jpg?x49793",
        "quantity": 7,
        "desc": ""
    }
]
  ngOnInit(): void {
    this.bookserv.booksData$.subscribe( data =>{
      this.books = data;
    })
    this.bookserv.getBooks()
  }
  addBook(book,value){
    this.cart.push({book,value})
    localStorage.setItem('cart',JSON.stringify(this.cart));
  }

}
