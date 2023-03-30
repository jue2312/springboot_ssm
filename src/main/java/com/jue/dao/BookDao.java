package com.jue.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jue.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author Pride
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
