package com.zh.springboot.demo.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zh.springboot.demo.entity.Student;

import java.util.List;

/**
 * 学生业务层接口
 */
public interface IStudentService {

    /**
     * 添加学生
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 根据学生ID删除学生
     * @param stuId
     * @return
     */
    int deleteStudent(Integer stuId);

    /**
     * 根据主键学生id查询获取一个学生的记录
     * @param stuId
     * @return
     */
    Student selectOne(int stuId);

    /**
     * 根据性别、学历字段查询学生信息
     * @param sex
     * @param edu
     * @return
     */
    List<Student> selectList(Integer sex, Integer edu);

    /**
     * 根据学生修改信息
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     *根据学历，性别作 分页查询
     * @param f 当前页第一条序号
     * @param sex
     * @param edu
     * @return
     */
    Page<Student> selectPage(Integer f, Integer sex, Integer edu);
}
