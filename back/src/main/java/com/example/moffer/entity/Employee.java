package com.example.moffer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
@TableName("employee")
@Data
public class Employee {

    private int id ;
    @TableField(value="employee_account")
    private  String employeeAccount;
    @TableField(value="employee_name")
    private String employeeName;
    @TableField(value="employee_gender")
    private String employeeGender;
    @TableField(value="employee_age")
    private int employeeAge;
    @TableField(value="employee_phone")
    private String employeePhone;
    @TableField(value="entry_time")
    @JsonFormat(pattern="YYYY-MM-DD HH:mm:ss")
    private String entryTime;
    private String staff;
    @TableField(value="employee_message")
    private String employeeMessage;


}
