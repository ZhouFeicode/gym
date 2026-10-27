package com.example.moffer.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
@TableName("equipment")
@Data
public class Equipment {
   private int id;
    @TableField(value="equipment_id")
    private int equipmentId;
   @TableField(value="equipment_name")
   private String equipmentName;
    @TableField(value="equipment_status")
    private String equipmentStatus;
    @TableField(value="equipment_location")
    private String equipmentLocation;
    @TableField(value="equipment_message")
    private String equipmentMessage;

}
