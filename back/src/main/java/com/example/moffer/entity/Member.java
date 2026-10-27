package com.example.moffer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("member")
@Data
public class Member {
    private int id;
    @TableField(value = "member_account")
    private int memberAccount;
    @TableField(value = "member_password")
    private String memberPassword;
    @TableField(value = "member_name")
    private String memberName;
    @TableField(value = "member_gender")
    private String memberGender;
    @TableField(value = "member_age")
    private int memberAge;
    @TableField(value = "member_height")
    private double memberHeight;
    @TableField(value = "member_weight")
    private double memberWeight;
    @TableField(value = "member_email")
    private String memberEmail;
    @TableField(value = "member_phone")
    private String memberPhone;
    @TableField(value = "card_time")
    private String cardTime;
}
