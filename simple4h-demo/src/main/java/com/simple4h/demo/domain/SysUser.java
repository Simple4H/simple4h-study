package com.simple4h.demo.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.simple4h.demo.config.EmailHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

/**
 * 用户表
 *
 * @author Simple4H
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user", autoResultMap = true)
public class SysUser {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.INPUT)
    private Long id;

    /**
     * 登录账号
     */
    @TableField(value = "username")
    private String username;

    /**
     * md5密码盐
     */
    @TableField(value = "password_salt")
    private String passwordSalt;

    /**
     * 头像
     */
    @TableField(value = "avatar")
    private String avatar;

    /**
     * 生日
     */
    @TableField(value = "birthday")
    private Date birthday;

    /**
     * 性别(0-默认未知,1-男,2-女)
     */
    @TableField(value = "sex")
    private Boolean sex;

    /**
     * 电子邮件
     */
    @TableField(value = "email", typeHandler = EmailHandler.class)
    private List<EmailHandler> email;

    /**
     * 电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 座机号
     */
    @TableField(value = "telephone")
    private String telephone;

    /**
     * 创建人
     */
    @TableField(value = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 更新人
     */
    @TableField(value = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    private Date updateTime;
}