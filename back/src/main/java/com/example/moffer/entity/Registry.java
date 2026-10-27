package com.example.moffer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("registry")
public class Registry {
    private int id;
    @TableField(value="course_id")
    private int courseId;
    @TableField(value="member_id")
    private String memberId;
    private String type;
    @TableField("registry_dt")
    private String registryDt;

}
