package com.jue.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jue.dao.BookDao;
import com.jue.domain.Book;
import com.jue.service.IBookService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pride
 */
@Service
public class BookServiceImpl extends ServiceImpl<BookDao, Book> implements IBookService  {

    @Autowired
    private BookDao bookDao;

    @Override
    public boolean modify(Book book){
        return bookDao.updateById(book) > 0;
    }

    @Override
    public boolean delete(Integer id){
        return bookDao.deleteById(id) > 0;
    }

    @Override
    public IPage<Book> ipage(int currentPage, int pageSize) {
        IPage<Book> iPage=new Page<>(currentPage,pageSize);
        bookDao.selectPage(iPage,null);
        return iPage;
    }

    @Override
    public IPage<Book> ipage(int currentPage, int pageSize, Book book) {
        LambdaQueryWrapper<Book> lqw= new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(book.getType()),Book::getType,book.getType());
        lqw.like(Strings.isNotEmpty(book.getName()),Book::getName,book.getName());
        lqw.like(Strings.isNotEmpty(book.getDescription()),Book::getDescription,book.getDescription());
        IPage<Book> iPage=new Page<>(currentPage,pageSize);
        bookDao.selectPage(iPage,lqw);
        return iPage;
    }
}
