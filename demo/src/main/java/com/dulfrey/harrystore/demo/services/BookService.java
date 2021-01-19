package com.dulfrey.harrystore.demo.services;

import java.util.List;

import com.dulfrey.harrystore.demo.model.entities.Book;

public interface BookService {
	List<Book> list();
	Book findOne(int id);
	Book add(Book book);
	Book buyBook(Book b) throws Throwable;
}
