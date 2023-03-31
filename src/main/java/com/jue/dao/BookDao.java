package com.jue.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jue.domain.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author Pride
 */
@Mapper
public interface BookDao extends BaseMapper<Book> {

}
