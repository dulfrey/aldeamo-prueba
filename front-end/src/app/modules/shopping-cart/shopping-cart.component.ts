import { Component, OnInit } from '@angular/core';
import { BooksService } from 'src/app/services/books.service';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.sass']
})
export class ShoppingCartComponent implements OnInit {
  cart: any;
  totalPrice = 0
  constructor(private bookservice: BooksService) { }

  ngOnInit(): void {
    let car = localStorage.getItem('cart');
    this.cart = JSON.parse(car)
    this.updateTotal()
  }
  removeBook(i){
    console.log(i)
    this.cart.splice(i,1)
    this.updateTotal()
  }
  buy(){
    this.cart.map( (item , index) => {
      this.bookservice.sellBook(item.book.id,item.value,index)
    })
  }
  cancel(){
    this.cart = []
    localStorage.setItem('cart',JSON.stringify(this.cart))
    this.updateTotal()
  }
  updateTotal(){
    this.totalPrice = 0 
    this.cart.map( item => {
      this.totalPrice = (item.book.price * item.value) + this.totalPrice
    })
  }
}
