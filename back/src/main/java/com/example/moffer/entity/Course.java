package com.example.moffer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Course {
    private int id;
    @TableField(value="course_id")
    private int courseId;
    @TableField(value="course_name")
    private String courseName;
    @TableField(value="employee_id")
    private String employeeId;
    @TableField(value="course_schedule")
    private String courseSchedule;
    @TableField(value="course_place")
    private String coursePlace;
    @TableField(value="course_price")
    private double coursePrice;
    @TableField(value="course_msg")
    private String courseMsg;
    @TableField(value="course_total")
    private int courseTotal;
    @TableField(value="course_status")
    private String courseStatus;

}
