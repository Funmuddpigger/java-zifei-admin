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
 * @since 2020-10-09
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;

    /**
     * 用户登录/注册账号
     */
    private String userAccount;

    private String userPassword;

    /**
     * 用户真实姓名
     */
    private String userRealname;

    private String userPhone;

    private String userEmail;

    private String userPay;

    private String userStatues;

    private String userAlwaysip;
    /**
     * ok or not ,true / false
     */
    private String  userIpok;

}
