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
public class ListerBilling implements Serializable {

    private static final long serialVersionUID = 1L;

    private String accountNumber;

    private String loginEntityTime;

    private Float cost;

    private String state;

    private String detailed;


}
