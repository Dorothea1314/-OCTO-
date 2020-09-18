package com.zh.springboot.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zh.springboot.demo.mapper.StudentMapper;
import com.zh.springboot.demo.vo.Result;
import com.zh.springboot.demo.entity.Student;
import com.zh.springboot.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 学生控制器对象
 */
@Controller
@RequestMapping("stu")
public class StudentController {
    //依赖注入
    @Autowired
    private IStudentService studentService;

    /**
     * 添加一个学生记录
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "create")  //@RequestMapping包含get,post //也可以写PostMapping
    public String createStudent(Student student, Model model) {
        int rows = studentService.insertStudent(student);
        model.addAttribute("rows", rows);
        //添加参数
        return "stu/query_stu";  //返回页面，不要加扩展名
    }

    /**
     * 通过edu、sex查询所有符合的学生
     *
     * @param edu
     * @param sex
     * @param model
     * @return
     */
    @RequestMapping(value = "query") //@RequestMapping包含get,post //也可以写PostMapping
    public String queryStudent(Integer edu, Integer sex, Model model) {
        System.out.println("edu==============" + edu + "\t sex=======" + sex);
        List<Student> studentList = studentService.selectList(sex, edu);
        model.addAttribute("studentList", studentList);
        return "stu/query_stu";
    }

    /**
     * 通过id删除学生信息
     *
     * @param stuId
     * @param model
     * @return
     */
    @RequestMapping(value = "delete/{stuId}")
    public String deleteStudent(@PathVariable Integer stuId, Model model) {
        int row = studentService.deleteStudent(stuId);
        model.addAttribute("row", row);
        return "stu/query_stu";
    }


    /**
     * 跳转页面
     *
     * @return
     */
    //PathVariable请求路径变量，根据所填写的
    @GetMapping("{viewName}") //动态路径
    public String forwardPage(@PathVariable("viewName") String viewName) {

        return "stu/" + viewName;
    }

    /**
     * 定义接口查询返回所有学生的数据
     */
    @RequestMapping("all")
    @ResponseBody //返回json对象
    public Result queryAll() {
        List<Student> studentList = studentService.selectList(0, 0);
        Result result = new Result();
        //设置返回的数据
        result.setResult(studentList);
        //设置状态
        result.setCode("0");
        //int i=3/0;  //加了这句话就产生异常，全局异常控制器捕捉到异常，转到500页面
        System.out.println(result);
        return result;
    }

    /**
     * 分页查询
     * @param current
     * @param edu
     * @param sex
     * @return
     */
    @RequestMapping(value = "paging")
    //@ResponseBody
    public String selectPage(Integer current,Integer edu,Integer sex,Model model) {
        Page<Student> page = studentService.selectPage(current, sex, edu);
        model.addAttribute("page",page); //records 查询打包结果集
        return "stu/query_stu";
    }
}
