package com.zh.springboot.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zh.springboot.demo.dao.IStudentDao;
import com.zh.springboot.demo.entity.Student;
import com.zh.springboot.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 事务：原子性，一致性，隔离性，永久性
 * 在项目中，对业务层方法进行管理，不在dao层中管理
 * 所有业务层方法自动加事务
 */
@Service("studentService")
public class StudentServiceImpl implements IStudentService {
    @Autowired
    private IStudentDao iStudentDao;

    //通过注解配置事务,propagation事务管理方式，事务传播性，REQUIRED当前操作需要一个事务
    //rollbackFor回滚操作 ，Exception.class异常类型，当业务层发生任意异常时候，取消前面所有操作
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int insertStudent(Student student) {
        return iStudentDao.insertStudent(student);
    }

    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public int deleteStudent(Integer stuId) {

     /*   iStudentDao.deleteStudent(stuId);
        int i=3/0;
        return i;*/
        //int i =3/0;
        return iStudentDao.deleteStudent(stuId);
    }

    //readOnly只读
    @Transactional(propagation = Propagation.REQUIRED,readOnly = true)
    public Student selectOne(int stuId) {
        //测试只读事务
        //iStudentDao.deleteStudent(stuId);
        return iStudentDao.selectOne(stuId);
    }

    public List<Student> selectList(Integer sex, Integer edu) {
        return iStudentDao.selectList(sex, edu);
    }

    public int updateStudent(Student student) {
        return iStudentDao.updateStudent(student);
    }

    @Override
    public Page<Student> selectPage(Integer f, Integer sex, Integer edu) {
        return iStudentDao.selectPage(f,edu,sex);
    }
}
