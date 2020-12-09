package com.example.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mine
 * @since 2020-11-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 用户账户

     */
    private String userAccount;

    /**
     * 用户这一次登录ip
     */
    private String userThisip;


}
