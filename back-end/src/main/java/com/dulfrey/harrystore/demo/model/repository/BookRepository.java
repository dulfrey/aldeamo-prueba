package com.dulfrey.harrystore.demo.model.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.dulfrey.harrystore.demo.model.entities.Book;

public interface BookRepository extends JpaRepository<Book,Integer> {
	
	List<Book> findAll();
	@SuppressWarnings("unchecked")
	@Modifying
	Book save(Book b);
	void delete(Book b);
	
	@Modifying
    @Transactional 
	@Query(value = "UPDATE books SET quantity= :qnt WHERE id=:id", nativeQuery = true)
	  void updateBookByID( @Param("id") int id,@Param("qnt")  int quantity);

}
