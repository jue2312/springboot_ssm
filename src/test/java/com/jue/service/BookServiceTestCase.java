package com.jue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.jue.domain.Book;
import com.jue.service.impl.BookServiceImpl;
import com.jue.service.impl.BookServiceImpl2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase {
    @Autowired
    private BookServiceImpl bookService;

    @Autowired
    private BookServiceImpl2 bookService2;
    @Test
    public void testSelectAll(){
        bookService2.selectAll().forEach(System.out::println);
    }
    @Test
     void testUpdate(){
        bookService2.delete(3);
    }
    @Test
    void testGetPage(){
        IPage<Book> page = bookService2.getPage(2, 5);
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
        System.out.println(page.getCurrent());
    }
    @Test
    void testSave(){
        Book book=new Book();
        book.setId(2);
        book.setName("Python");
        book.setType("你猜你猜啊");
        book.setDescription("wsmsmdakjdl");
        bookService.save(book);
    }

}
