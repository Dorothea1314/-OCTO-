package com.zh.springboot.demo.dao.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zh.springboot.demo.dao.IStudentDao;
import com.zh.springboot.demo.entity.Student;
import com.zh.springboot.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * StudentDao接口的实现类
 * 一次只能进行一个操作，不能进行两个操作
 */
//@Component 通用的，可以用于所有组件
@Repository("studentDao") //仓库的意思
public class StudentDaoImpl implements IStudentDao {
    @Autowired  //自动装配 ，根据类型 //(required = false)表示忽略当前要注入的bean，如果有直接注入，没有跳过，不会报错。
    private StudentMapper studentMapper;

    public int insertStudent(Student student) {

        return   studentMapper.insert(student);
    }

    public int deleteStudent(Integer stuId) {
        return studentMapper.deleteById(stuId);
    }

    public Student selectOne(int stuId) {
        return studentMapper.selectById(stuId);
    }

    public List<Student> selectList(Integer sex, Integer edu) {
        /**
         * QueryWrapper 用来打包查询条件
         */
        QueryWrapper<Student> wrapper = new QueryWrapper<Student>();
        //column:"sex"  是表字段
        if (sex!=null&&sex!=0) {  //压根没传，或者传的时候值为0
            wrapper.eq("sex", sex);
        }
        if (edu!=null&&edu!=0) {
            wrapper.eq("edu", edu);
        }
//        if(!StringUtils.isEmpty(sex)){
//            wrapper.eq("sex", sex);
//        }
//        if(!StringUtils.isEmpty(edu)&&edu!=0){
//            wrapper.eq("edu", edu);
//        }
        //上面的方法也行

        return studentMapper.selectList(wrapper);
    }

    public int updateStudent(Student student) {
        return studentMapper.updateById(student);
    }

    @Override
    public Page<Student> selectPage(Integer f,Integer sex, Integer edu) {
        /**
         * QueryWrapper 用来打包查询条件
         */
        QueryWrapper<Student> wrapper = new QueryWrapper<Student>();
        /*if (f!=null&&f!=0) {  //压根没传，或者传的时候值为0
            wrapper.eq("f", f);
        }*/
        //column:"sex"  是表字段
        System.out.println("f"+f+""+sex+edu);
        if (sex!=null&&sex!=0) {  //压根没传，或者传的时候值为0
            wrapper.eq("sex", sex);
        }
        if (edu!=null&&edu!=0) {
            wrapper.eq("edu", edu);
        }
        //创建一个page对象
        Page<Student> page = new Page();
        //设置当前页第一条序号

        page.setCurrent(f);
        //每页显示5条数据
        page.setSize(5);
        //设置升序
        wrapper.orderByAsc("stu_id");

        return studentMapper.selectPage(page,wrapper);
    }


}
