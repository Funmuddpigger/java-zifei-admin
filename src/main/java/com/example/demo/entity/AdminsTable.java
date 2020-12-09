package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mine
 * @since 2020-10-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AdminsTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    @TableId(value = "admin_id", type = IdType.AUTO)
    private Integer adminId;

    private int account;

    private String pass;

    private String passConfirm;

    private String realname;

    private String email;

    private String openDate;

    private String phone;

    private String power1;

    private String power2;

    private String power3;

    private String power4;

    private String power5;



}
