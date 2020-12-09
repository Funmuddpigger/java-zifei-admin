package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author mine
 * @since 2020-10-28
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class PostageTable implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 资费名称
     */
    private String postageName;

    /**
     * 月租费用
     */
    private String monthlyRent;

    /**
     * 每小时费用
     */
    private String hourlyRent;

    /**
     * 资费描述
     */
    private String postageDescription;


}
