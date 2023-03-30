package com.jue.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDto;
import com.jue.domain.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class BookDaoTestCase {
    @Resource
    private BookDao bookDao;

    @Test
    void testGetById() {
        System.out.println(bookDao.selectById(1));

    }

    @Test
    void testSave() {
        Book book = new Book();
        book.setType("测试数据一");
        book.setName("测试数据一");
        book.setDescription("测试数据一");
        bookDao.insert(book);
    }

    @Test
    void testGetAll() {
        System.out.println(bookDao.selectList(null));

    }

    @Test
    void testDeleteById() {
        bookDao.deleteById(2);

    }

    @Test
    void testUpdate() {
        Book book = new Book();
        book.setId(1);
        book.setType("啊啊啊啊啊啊啊");
        book.setName("为什么为什么");
        book.setDescription("为什么为什么");
        bookDao.updateById(book);

    }

    @Test
    void testGetBy() {
        QueryWrapper<Book> wrapper = new QueryWrapper<>();
        wrapper.like("type", "你猜");
        bookDao.selectList(wrapper);

    }

    @Test
    void testGetBy2() {
        String name = "1";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        //if (lqw != null) lqw.like(Book::getType,name);
        lqw.like(name != null, Book::getType, name);
        bookDao.selectList(lqw);

    }

    @Test
    void testGetPage() {
        IPage iPage = new Page(3, 5);
        System.out.println(bookDao.selectPage(iPage, null));
        System.out.println(iPage.getCurrent());
        System.out.println(iPage.getTotal());
        System.out.println(iPage.getPages());
        System.out.println(iPage.getSize());
        System.out.println(iPage.getRecords());

    }

}
