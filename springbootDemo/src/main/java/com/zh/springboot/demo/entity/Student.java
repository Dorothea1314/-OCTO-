package com.zh.springboot.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;


import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Alias("stu")  //第二种方法，通过注解给每个实体类加上别名
@Data  //lombok插件  自动生成setter/getter/toString方法
@TableName("student") //将表与类一一映射起来，名称与表名一致
public class Student {
    /**
     * 学生ID
     */
    //id类型为主键，自动增长
    @TableId(type = IdType.AUTO)
    //@TableField(value ="stu_id")  //在表中对应的字段名称
    //按照他的驼峰原则自动匹配成功
    private Integer stuId;    //匹配成功
    /**
     * 姓名
     */
    //原则：字段名与属性名称相同，匹配成功；若不同，
    private String name;
    /**
     * 性别(1:男;2:女)
     */
    private Integer sex;
    /**
     * 身份证号码
     */
    private String idCard;
    /**
     * 专业
     */
    private String subject;
    /**
     * 学历(1:中专;2:大专;3:本科;4:硕士;5:其它)
     */
    private Integer edu;
    /**
     * 出生日期，
     * mysql数据库可以加"",把string类型转换成data，存入数据库
     * Oracle不可以
     */
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    /**
     * 一个学生拥有多个简历
     */
   /* @TableField(exist = false) //表中不存在一个字段与此属性关联，忽略此属性关联表字段
    private List<Resume> resumeList;*/




}
