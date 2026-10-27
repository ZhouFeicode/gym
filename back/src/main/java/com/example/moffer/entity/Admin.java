package com.example.moffer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("admin")
@Data
public class Admin {
    private int id;
    @TableField(value="admin_account")
    private String  adminAccount;
    @TableField(value="admin_password")
    private String adminPassword;
}
