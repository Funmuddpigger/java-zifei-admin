package com.example.demo.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mine
 * @since 2020-10-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ListerDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 业务账号
     */
    private String businessAccountNumber;

    private String server;

    private String totalTime;

    /**
     * 总费用
     */
    private Float totalCost;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 退出时间
     */
    private LocalDateTime exitTime;

    /**
     * 时长
     */
    private Integer duration;


}
