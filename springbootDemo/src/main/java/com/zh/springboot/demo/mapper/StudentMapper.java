package com.zh.springboot.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh.springboot.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * Student Mapper接口
 */

/**
 * 继承BaseMapper超类
 */
@Controller("studentMapper")
@Mapper  //spring boot里面加入扫描的包
public interface StudentMapper extends BaseMapper<Student> {

    // List<Student> selectPage();
}


