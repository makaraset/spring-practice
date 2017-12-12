package com.mkr.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.mkr.model.Book;

@Repository
public interface MybaticBookRepository {
	
	@Select("select * from book")
	public List<Book> findAll();
	
	@Select("select * from book where id =#{id}")
	public Book findById(int id);
	
	@Insert("insert into book values(#{id},#{title},#{publishDate},#{author},#{page},#{coverImage})")
	public boolean addBook(Book book);
	
	@Delete("delete from book where id=#{id}")
	public boolean removeBook(Book book);
	
	@Update("update book set title=#{title}, publishdate=#{publishDate}, author=#{author}, page=#{page}, coverimage=#{coverImage} where id=#{id}" )
	public boolean updateBook(Book book);
}
