package com.dulfrey.harrystore.demo.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.dulfrey.harrystore.demo.model.entities.Book;
import com.dulfrey.harrystore.demo.services.BookService;


@CrossOrigin(origins="*",methods= {RequestMethod.GET,RequestMethod.POST}, maxAge=3600)
@RestController
@RequestMapping({"/books"})
public class BookController {
	@Autowired
	BookService bookservice;
	
	@GetMapping
	public List<Book> list(){
		return bookservice.list();
	};

	@PostMapping
	public Book add(@RequestBody Book b){
		return bookservice.add(b);
	};
	@PostMapping("/buy")
	public Map<String, String> edit(@RequestBody Book b){
		try {
			Book n = bookservice.buyBook(b);
			HashMap<String, String> map = new HashMap<>();
		    map.put("status", "success");
		    map.put("message", "book " + n.getName() + " " + "sold" );
		    return map;
		}catch(Throwable err) {
			err.printStackTrace();
		}
		HashMap<String, String> map = new HashMap<>();
	    map.put("status", "error");
	    map.put("message", "no enough stok");
	    return map;
	};

}
