package com.jue.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jue.domain.Book;

public interface IBookService extends IService<Book> {
    IPage<Book> ipage(int currentPage,int pageSize);
    IPage<Book> ipage(int currentPage,int pageSize,Book book);
    boolean modify(Book book);

    boolean delete(Integer id);
}
