package com.jue.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDto;
import com.jue.dao.BookDao;
import com.jue.domain.Book;
import com.jue.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl2 implements BookService {
    //自动装配
    @Autowired
    private BookDao bookDao;

    /**
     * 插入一条记录
     * @param book
     * @return
     */
    @Override
    public Boolean save(Book book) {
        return bookDao.insert(book) > 0;
    }

    /**
     * 修改记录
     * @param book
     * @return
     */
    @Override
    public Boolean update(Book book) {
        return bookDao.updateById(book) > 0;
    }

    /**
     * 根据id删除一条记录
     * @param id
     * @return
     */
    @Override
    public Boolean delete(Integer id) {
        return bookDao.deleteById(id) > 0;
    }

    /**
     * 根据id查询一条记录
     *
     * @return
     */
    @Override
    public Book selectById() {
        return selectById(null);
    }

    /**
     * 根据id查询一条记录
     * @param id
     * @return
     */
    @Override
    public Book selectById(Integer id) {
        return bookDao.selectById(id);
    }

    /**
     * 查询所有记录
     * @return
     */
    @Override
    public List<Book> selectAll() {
        return bookDao.selectList(null);
    }

    @Override
    public IPage<Book> getPage(int currentPage, int pageSize) {
        IPage iPage=new PageDto(currentPage,pageSize);

        return bookDao.selectPage(iPage,null);
    }
}
