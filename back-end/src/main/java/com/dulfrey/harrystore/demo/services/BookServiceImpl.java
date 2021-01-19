package com.dulfrey.harrystore.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulfrey.harrystore.demo.model.entities.Book;
import com.dulfrey.harrystore.demo.model.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repo;
	
	
	@Override
	public List<Book> list() {
		return repo.findAll();
	}

	@Override
	public Book findOne(int id) {
		return null;
	}

	@Override
	public Book add(Book book) {
		return repo.save(book);
	}

	@Override
	public Book buyBook(Book b) throws Throwable {
		Book n = repo.getOne(b.getId());
		if(n.getQuantity() - b.getQuantity() < 0 ){
			throw new Exception();
		}
		n.setQuantity(n.getQuantity() - b.getQuantity());
		return  repo.save(n);
	}
	
}
